package com.bonc.leetcode_solution;

public class Q283 {
    public void moveZeroes(int[] nums) {

        // 2´Î±éÀú
//		int notzeros = 0;
//		for (int i = 0; i < nums.length-1; i++) {
//			if (nums[i]!=0) {
//				nums[notzeros] = nums[i];
//				notzeros++;
//			}
//		}
//		for (int i = notzeros; i < nums.length; i++) {
//			nums[i] = 0;
//		}

        // Ë«Ö¸Õë
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i++] = tmp;
                j++;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
