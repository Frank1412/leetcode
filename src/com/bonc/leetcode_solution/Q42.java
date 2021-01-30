package com.bonc.leetcode_solution;

public class Q42 {

	public static int trap(int[] height) {
		
		// ������
//		int trapArea = 0;
//		for (int i = 1; i < height.length-1; i++) {
//			int left = i-1, right = i+1;
//			int max_left = 0, max_right = 0;
//			while(left>=0) {
//				max_left = Math.max(max_left, height[left]);
//				left--;
//			}
//			while(right<height.length) {
//				max_right = Math.max(max_right, height[right]);
//				right++;
//			}
//			int min = Math.min(max_left, max_right);
//			int add = height[i]<min?(min-height[i]):0;
//			trapArea += add;
//		}
//		return trapArea;
		
		// ��̬�滮
//		int trapArea = 0;
//		int []left_max = new int[height.length];
//		int []right_max = new int[height.length];
//		int max_left = 0, max_right=0;
//		for (int i = 1; i < height.length; i++) {
//			left_max[i] = Math.max(left_max[i-1], height[i-1]);
//		}
//		for (int i = height.length-2; i > -1; i--) {
//			right_max[i] = Math.max(right_max[i+1], height[i+1]);
//		}
//		for (int i = 1; i < height.length-1; i++) {
//			int min = Math.min(left_max[i], right_max[i]);
//			int add = height[i]<min?(min-height[i]):0;
//			trapArea += add;
//		}
//		return trapArea;
		
		// ˫ָ��
		int trapArea = 0;
		int left = 1, right = height.length-2, max_left = 0, max_right = 0;
		while (left<=right) {
			max_left = Math.max(max_left, height[left-1]);
			max_right = Math.max(max_right, height[right+1]);
			if (max_left<max_right) {
				trapArea += max_left>height[left]?max_left-height[left]:0;
				left++;
			}else {
				trapArea += max_right>height[right]?max_right-height[right]:0;
				right--;
			}
		}
		
		return trapArea;
    }
	
	public static void main(String[] args) {
		int []a = {4,2,0,3,2,5};
		int area = trap(a);
		System.out.println(area);
	}
}
