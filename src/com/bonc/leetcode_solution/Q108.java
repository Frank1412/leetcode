package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-21 14:09
 * @description:
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 *
 */
public class Q108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int nums[], int i, int j){
        if (i>j) return null;

        int mid = i + (j-i)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, i, mid-1);
        root.right = helper(nums, mid+1, j);
        return root;
    }
}
