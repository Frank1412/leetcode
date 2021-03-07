package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-07 9:47
 * @description:
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 *
 */
public class Q746 {

    public int minCostClimbingStairs(int[] cost) {
        // costSum[i] 表示到达i的上面需要的cost
        int[] costSum = new int[cost.length];
        costSum[0] = 0;
        costSum[1] = Math.min(cost[0], cost[1]);
        for(int i=2;i<cost.length;i++){
            costSum[i] = Math.min(cost[i]+costSum[i-1], cost[i-1]+costSum[i-2]);
        }

        return costSum[cost.length-1];
    }
}
