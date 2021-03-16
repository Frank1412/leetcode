package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-16 20:48
 * @description:
 * A sequence X1, X2, ..., Xn is Fibonacci-like if:
 *
 * n >= 3
 * Xi + Xi+1 = Xi+2 for all i + 2 <= n
 * Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
 *
 * A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
 *
 */
public class Q873 {

    int[][]memo;
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        memo  = new int[n][n-1];
        for(int[] m: memo){
            m[0]=2;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){
            map.put(arr[i], i);
        }
        int max = 0;
        for (int j=n-1;j>=1;j--){
            for (int i=j-1;i>=0;i--){
                int diff = arr[j]-arr[i];
                if (map.containsKey(diff)){
                    max = Math.max(max, dfs(arr, j, i, map));
                }else{
                    max = Math.max(max, 2);
                }
            }
        }
        return max==2?0:max;
    }

    private int dfs(int[] arr, int j, int i, Map<Integer,Integer> map){

        if(memo[j][i]!=0){
            return memo[j][i];
        }

        int res=2;
        int diff = arr[j]-arr[i];
        if(map.containsKey(diff)){
            if(map.get(diff)<i){
                res = Math.max(dfs(arr, i, map.get(diff), map)+1, res);
            }
        }

        return memo[j][i]=res;
    }

    public static void main(String[] args) {
        System.out.println(new Q873().lenLongestFibSubseq(new int[]{1,2,3,4,5,8,13}));
    }
}
