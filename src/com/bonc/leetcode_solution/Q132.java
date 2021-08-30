package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-28 16:14
 * @description: hard 未完成
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * Example 2:
 * Input: s = "a"
 * Output: 0
 *
 * Example 3:
 * Input: s = "ab"
 * Output: 1
 *
 */
public class Q132 {

    public int minCut(String s) {
        return dfs(s, 0, s.length());
    }

    private int dfs(String s, int start, int end){
        if (start>end){
            return 0;
        }
        if (isPalindrome(s, start, end)){
            return 0;
        }

        int left=0, right=0, curmin=end-start;
        for (int i=start;i<=end;i++){
            if (!isPalindrome(s, start, i)){
                left = dfs(s, start, i);
            }
            if (!isPalindrome(s, i+1, end)){
                right = dfs(s, i+1, end);
            }

            curmin = Math.min(left+right+1, curmin);
        }

        return curmin;
    }

    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if (s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
