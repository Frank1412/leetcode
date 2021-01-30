package com.bonc.leetcode_solution;

public class Q11 {
	
	public int maxArea(int[] height) {
		int p = 0,q = height.length-1;
		int maxArea = (q-p)*Math.min(height[p], height[q]);
		while(p<q) {
			if (height[p]<height[q]) {
				p++;
			}else {
				q--;
			}
			maxArea = Math.max(maxArea, (q-p)*Math.min(height[p], height[q]));
		}
		return maxArea;
    }
	public static void main(String[] args) {
		
	}

}
