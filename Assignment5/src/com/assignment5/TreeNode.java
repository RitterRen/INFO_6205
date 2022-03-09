package com.assignment5;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int value) {
        val = value;
    }

    public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
        val = value;
        left = leftNode;
        right = rightNode;
    }
}
