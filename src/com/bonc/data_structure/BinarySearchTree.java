package com.bonc.data_structure;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-04 21:39
 */
public class BinarySearchTree {

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public TreeNode get(int val){
        TreeNode cur = root;
        while (cur!=null && cur.value!=val){
            if (cur.value > val){
                cur = cur.left;
            }
            if (cur.value < val){
                cur = cur.right;
            }
        }
        return cur==null? null:cur;
    }

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
        }

        TreeNode cur = root;
        while (true) {
            if (cur.value > val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    cur = cur.left;
                    break;
                }else{
                    cur = cur.left;
                }
            }
            if (cur.value < val) {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    cur = cur.right;
                    break;
                }else{
                    cur = cur.right;
                }
            }
            if (cur.value == val) return;
        }
    }

    public Boolean delete(int val) {
        TreeNode parent = root, cur = root;
        Boolean isLeftChild = true;
        while (cur != null && cur.value != val) {
            if (cur.value > val) {
                parent = cur;
                cur = cur.left;
                isLeftChild = true;
            } else {
                parent = cur;
                cur = cur.right;
                isLeftChild = false;
            }
        }
        if (cur == null) {
            return false;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        }
        if (cur.left == null && cur.right != null) {
            if (isLeftChild) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        }
        if (cur.left != null && cur.right == null) {
            if (isLeftChild) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        }
        if (cur.left != null && cur.right != null) {
            // 找右子树的最小值Node
            TreeNode replacer = replacer(cur.right);
            replacer.left = parent.left;
            if (cur==root){
                root = replacer;
            }
//            if (isLeftChild){
//                parent.left = replacer;
//            }else{
//                parent.right = replacer;
//            }
        }
        return true;
    }

    // 找右子树的最小值Node
    public TreeNode replacer(TreeNode subRoot){
        TreeNode cur = subRoot, parent = subRoot;
        while (cur.left!=null){
            parent = cur;
            cur = cur.left;
        }
        if (cur!=subRoot){
            cur.right = subRoot;
            parent.left = null;
        }

        return cur;
    }

    public void preOrderTraversal(TreeNode root){
        if (root == null){
            return ;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(1);
        bst.insert(2);
        bst.insert(6);
//        System.out.println(bst.root.left);
        bst.preOrderTraversal(bst.root);
        System.out.println(bst.delete(5));
        bst.preOrderTraversal(bst.root);
    }
}
