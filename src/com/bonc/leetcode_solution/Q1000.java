package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-22 19:56
 * @description:
 * There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.
 *
 * A move consists of merging exactly K consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these K piles.
 *
 * Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.
 *
 */
public class Q1000 {
    int[][][] memo;
    int[] sum;
    int K;
    private static final int INF = 0x3f3f3f3f;
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        this.K = K;
        memo = new int[n][n][K+1];
        sum=new int[n];
        sum[0] = stones[0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1]+stones[i];
        }
        int res = dfs(0, n-1, 1);
        return res < INF ? res : -1;
    }

    /**
     * 动态规划
     * 定义状态: f[i][j][k] 表示将 [i, j] 区间的石头缩小成 k 堆的最小体力花费
     * 合法状态: j-i+1 >= k
     * 最终答案: f[0][n-1][1]
     * 状态转移: 想要把 [i, j] 区间的合并成 1 堆, 那么它的上一个状态一定是 K 堆
     *          f[i][j][1] = f[i][j][K] + sum(i, j)
     *          而对于非 1 的情况, 即 f[i][j][k], 我们需要考虑从 i 开始的多长的区间最终合并成 1 堆
     *          f[i][j][k] = min{ f[i][j'][1] + f[j'+1][j][k-1] }
     *
     * @param i
     * @param j
     * @param k
     * @return
     */
    private int dfs(int i, int j,int k){
        if(j-i+1<k){
            return INF;
        }
        if(j-i+1==k){
            return 0;
        }
        if(memo[i][j][k]!=0){
            return memo[i][j][k];
        }
        if(k==1){
            memo[i][j][k] = getSum(i,j)+dfs(i, j, K);
            return memo[i][j][k];
        }
        int min=INF;
        for(int m=i;m<j;m++){
            min = Math.min(dfs(i, m, 1)+dfs(m+1, j, k-1), min);
        }
        return memo[i][j][k]=min;
    }

    private int getSum(int i, int j){
        return i==0?sum[j]:sum[j]-sum[i-1];
    }
}
