package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-02 21:59
 * @description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 。
 */
public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0) return new int[]{-1,-1};
        int[] res = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j-1) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        if (nums[i]==nums[j]){
            if (nums[i]==target){
                res[0] = i;
            }else{
                return new int[]{-1,-1};
            }
        }else{
            if (nums[i]==target){
                res[0] = i;
                res[1] = i;
            }else{
                if (nums[j]==target){
                    res[0] = j;
                }else{
                    return new int[]{-1,-1};
                }
            }
        }
        int left = target==nums[i]?i:j, right=nums.length-1;
        while (left<right-1){
            int mid = left + (right-left)/2;
            if (nums[mid] <= target) {
                left = mid;
            }else{
                right = mid-1;
            }
        }
        if (nums[right] == target) {
            res[1] = right;
        }else{
            res[1] = left;
        }
        return res;
    }
}
