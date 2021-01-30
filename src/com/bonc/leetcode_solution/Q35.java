package com.bonc.leetcode_solution;

public class Q35 {
	public int searchInsert(int[] nums, int target) {
        int i=0, j=nums.length-1;
        while(i<j){
            int mid = i + (j-i+1)/2;
            if(nums[mid]>target){
                j = mid-1;
            }else{
                i = mid;
            }
        }
        if (nums[i]<target){
            return i+1;
        }else {
            return i;
        }
    }
}
