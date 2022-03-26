package com.BinarySearchTree;

public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {
        this.val = 0;
    }

    public TreeNode(int value) {
        val = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = value;
    }
}
