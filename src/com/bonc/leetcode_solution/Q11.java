package com.bonc.leetcode_solution;

public class Q11 {
	
	public int maxArea(int[] height) {

		// 双指针 证明：
		/**
		 * 设每一状态下水槽面积为 S(i, j)S(i,j),(0 <= i < j < n)(0<=i<j<n)，由于水槽的实际高度由两板中的短板决定，则可得面积公式 S(i, j) = min(h[i], h[j]) × (j - i)S(i,j)=min(h[i],h[j])×(j−i)。
		 * 在每一个状态下，无论长板或短板收窄 11 格，都会导致水槽 底边宽度 -1−1：
		 * 若向内移动短板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此水槽面积 S(i, j)S(i,j) 可能增大。
		 * 若向内移动长板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
		 */

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
