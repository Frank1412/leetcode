package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-02 20:54
 * @description: 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 */
public class Q33 {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            System.out.println(left + "  " + right);
            int mid = left + (right - left) / 2;
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    if (nums[mid] > nums[right]) {
                        if (nums[left] > target) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (nums[mid]>nums[left]){
                        left = mid+1;
                    }else{
                        if (nums[left]>target){
                            left = mid+1;
                        }else{
                            right = mid-1;
                        }
                    }
                }
            }
        }
        if (nums[left] == target) return left;
        else return -1;
    }

    public static void main(String[] args) {
        search(new int[]{8,9,2,3,4}, 9);
    }
}
