package com.bonc.leetcode_solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-21 18:54
 * @description:
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [0]
 * Output: [0]
 *
 */
public class Q114 {
    public void flatten(TreeNode root) {

        // 把root.right 接到root.left的最right节点，处理root.left, 迭代下去
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }

        // 用list按前序遍历存储TreeNode
        List<TreeNode> list = new LinkedList<>();
        helper(root, list);
        int size = list.size();
        list.add(null);
        for (int i=0;i<size;i++){
            TreeNode cur = list.get(i), next = list.get(i+1);
            cur.left = null;
            cur.right = next;
        }
    }

    private void helper(TreeNode root, List<TreeNode> list){
        if (root==null) return;
        list.add(root);
        helper(root.left, list);
        helper(root.right, list);
    }
}
