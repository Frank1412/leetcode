package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-07 16:45
 * @description:
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 *
 * Example 1:
 * Input: n = 3
 * Output: 5
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 *
 */
public class Q96 {
    public static int numTrees(int n) {
        int[] nums = new int[n+1];
        int res = dfs(n, nums);
        return res;
    }

    /**
     * bottom up（bottom to top） 动态规划 自底向上方法
     * @param n number of Node
     * @param nums record the number of subTree
     * @return
     */
    public static int dfs(int n, int[] nums){
        if (n<=1) return 1;

        if (nums[n]!=0){
            return nums[n];
        }

        int sum = 0;
        for (int i=1;i<=n;i++){
            int left = dfs(i-1, nums);
            int right = dfs(n-i, nums);
            sum += left*right;
        }
        nums[n] = sum;
        return sum;
    }

    public static void main(String[] args) {
        int res = numTrees(3);
        System.out.println(res);
    }
}
