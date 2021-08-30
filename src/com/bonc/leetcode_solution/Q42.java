package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-04 21:22
 * @description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 */
public class Q42 {

	public static int trap(int[] height) {

		// 动态规划
		if (height.length==0) return 0;
		int area = 0;
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		leftMax[0] = height[0];
		rightMax[height.length-1] = height[height.length-1];
		for (int i=1;i<height.length-1;i++){
			leftMax[i] = Math.max(leftMax[i-1], height[i]);
			rightMax[height.length-1-i] = Math.max(rightMax[height.length-i], height[height.length-1-i]);
		}
		for (int i=0;i<leftMax.length;i++){
			if (Math.min(leftMax[i], rightMax[i])-height[i]>0){
				area += Math.min(leftMax[i], rightMax[i])-height[i];
			}
		}

		return area;
    }
	
	public static void main(String[] args) {
		int []a = {4,2,0,3,2,5};
		int area = trap(a);
		System.out.println(area);
	}
}
