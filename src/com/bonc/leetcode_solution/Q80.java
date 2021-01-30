package com.bonc.leetcode_solution;

public class Q80 {
	public int removeDuplicates(int[] nums) {
		int i=1,j=1;
		boolean dup = false;
		while(i<nums.length) {
			if (nums[i]==nums[j-1] & !dup) {
				nums[j++] = nums[i++];
				dup = true;
			}else if (nums[i]==nums[j-1] & dup) {
				i++;
			}else if (nums[i]!=nums[j-1]) {
				nums[j++] = nums[i++];
				dup = false;
			}
		}
		return j;
    }
	
	public static void main(String[] args) {
		String s = "oaigrj";
		
	}
}
