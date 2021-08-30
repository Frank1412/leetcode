package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-26 9:19
 * @description: Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * <p>
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * Example 3:
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 */
public class Q75 {
    public void sortColors(int[] nums) {

        // 单指针 2次遍历
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//                j++;
//            }
//        }
//        for (int i = j; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = tmp;
//                j++;
//            }
//        }

        // 双指针
        int p0 = 0, p2 = nums.length - 1;
        for (int i=0;i<=p2;i++){
            if (nums[i]==0){
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                p0++;
            }
            while (i<=p2&&nums[i]==2){
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
        }
    }


}
