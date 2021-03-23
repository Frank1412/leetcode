package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-18 20:41
 * @description:
 * Given a string s. In one step you can insert any character at any index of the string.
 *
 * Return the minimum number of steps to make s palindrome.
 *
 * A Palindrome String is one that reads the same backward as well as forward.
 *
 */
public class Q1312 {
    Integer[][] memo;
    public int minInsertions(String s) {
        int len = s.length();
        memo = new Integer[len][len];
        return dfs(s, 0, len-1);
    }

    private int dfs(String s, int i, int j){
        if(i>=j){
            return 0;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }

        int res=0;
        if(s.charAt(i)==s.charAt(j)){
            res = dfs(s, i+1, j-1);
        }else{
            res = Math.min(dfs(s, i+1, j), dfs(s, i, j-1))+1;
        }
        return memo[i][j]=res;
    }
}
