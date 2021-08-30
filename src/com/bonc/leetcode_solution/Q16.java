package com.bonc.leetcode_solution;
import java.util.Arrays;
/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-06-28 12:58
 * @description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */
public class Q16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res=100000;
        for(int i=0;i<nums.length;i++){
            int tgt = target - nums[i];
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == target) {
                    return target;
                }
                if (sum > target) {
                    if (Math.abs(sum-target)<Math.abs(res-target)){
                        res = sum;
                    }
                    k--;
                }else{
                    if (Math.abs(sum-target)<Math.abs(res-target)){
                        res = sum;
                    }
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int result = threeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(result);
    }
}
