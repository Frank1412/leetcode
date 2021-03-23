package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-18 20:52
 * @description:
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
 *
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
 *
 * Return the maximum coins you can collect by bursting the balloons wisely.
 */
public class Q312 {

    Integer[][] memo;
    boolean[] visited;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];
        visited = new boolean[n];
        int max = 0;
        for(int i=0;i<n;i++){
            visited[i]=true;
            if(i==0){
                max = Math.max(max, dfs(nums, 1, n-1)+nums[0]*nums[1]);
                continue;
            }
            if (i==n-1){
                max = Math.max(max, dfs(nums, 0, n-2)+nums[n-1]*nums[n-2]);
                continue;
            }
            max = Math.max(max, dfs(nums, 0, i-1)+dfs(nums, i+1, n-1)+nums[i-1]*nums[i]*nums[i+1]);
            visited[i]=false;
        }
        return max;
    }

    private int dfs(int[] nums, int i, int j){
        if(i==j){
            return nums[i];
        }
        if(i>j){
            return 0;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }

        int max=0;
        for(int k=i;k<=j;k++){
            visited[k]=true;

            int right=k+1;
            while(right<nums.length){
                if(visited[right]){
                    right++;
                }else break;
            }

            int left=j-1;
            while(left>-1){
                if(visited[left]){
                    left--;
                }else break;
            }

            int mul = (right<nums.length?nums[right]:1)*nums[k]*(left>-1?nums[left]:1);
            max = Math.max(max, dfs(nums, i, k-1)+dfs(nums, k+1, j)+mul);
            visited[k] = false;
        }
        return memo[i][j] = max;
    }
}
