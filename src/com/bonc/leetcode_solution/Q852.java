package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-06-15 11:37
 * @description:
 */
public class Q852 {

    public int peakIndexInMountainArray(int[] arr) {
        int i=0, j = arr.length;
        while(i<j){
            int mid = i+(j-i)/2;
            if (arr[mid]>arr[mid+1]){
                j = mid;
            }else{
                i = mid+1;
            }
        }
        return i;
    }

    public static void main(String[] args){

    }
}
