package com.bonc.leetcode_solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-14 9:27
 * @description:
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */
public class Q120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<int[]> memo = new LinkedList<>();
        for (int i=0;i<triangle.size();i++){
            memo.add(i, new int[i+1]);
        }
        return dfs(triangle, memo, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, List<int []> memo, int i, int j){
        if(i>triangle.size()-1||j>triangle.get(i).size()-1){
            return 0;
        }

        if(memo.get(i).length-1>=j&&memo.get(i)[j]!=0){
            return memo.get(i)[j];
        }

        int left = dfs(triangle, memo, i+1, j);
        int right = dfs(triangle, memo, i+1, j+1);
        int res = Math.min(left, right)+triangle.get(i).get(j);

        memo.get(i)[j]=res;
        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = new LinkedList<>();
        a.set(3, 10);

        System.out.println(a.size());
    }
}
