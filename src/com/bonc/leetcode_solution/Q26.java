package com.bonc.leetcode_solution;

public class Q26 {

	public int removeDuplicates(int[] nums) {
		int j=0,i=0;
		while(j<nums.length) {
			if (i==0&j==0) {
				i++;j++;
			}else {
				if (nums[j]==nums[i-1]) {
					j++;
				}else {
					nums[i]=nums[j];
					i++;
					j++;
				}
			}
		}
		return i;
	}

	public static void main(String[] args) {

	}
}
