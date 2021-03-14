package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-14 15:42
 * @description:
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].
 *
 * The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.
 *
 * Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.
 *
 * Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.
 */
public class Q877 {
    public boolean stoneGame(int[] piles) {
        int m = piles.length;
        Integer[][] memo = new Integer[m][m];

        return dfs(memo, piles, 0, m-1)>0;
    }

    private int dfs(Integer[][] memo, int piles[], int i, int j){

        if (i==j){
            return piles[i];
        }

        if (memo[i][j]!=null){
            return memo[i][j];
        }

        int res = Math.max(piles[i]-dfs(memo, piles, i+1, j), piles[j]-dfs(memo, piles, i, j-1));
        memo[i][j] = res;
        return res;
    }
}
