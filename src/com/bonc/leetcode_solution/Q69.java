package com.bonc.leetcode_solution;

public class Q69 {
	 public static int mySqrt(int x) {
	        int left=0,right=x, ans = 0;

	        while(left <= right){
	            int mid =left + (right-left)/2;
	            System.out.println(mid);
	            if((long)mid*mid > x){
	                right = mid-1;
	            }else{
	            	ans = mid;
	                left = mid+1;
	            }
	        }
	        return ans;
	    }
	 public static void main(String[] args) {
		System.out.println(mySqrt(2147483647));
	}
}
