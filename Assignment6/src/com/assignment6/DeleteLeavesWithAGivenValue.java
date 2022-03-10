package com.assignment6;

public class DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        helper(root, target);

        if (root.left == null && root.right == null && root.val == target) return null;
        return root;
    }

    private TreeNode helper(TreeNode root, int target) {
        if (root == null) return null;

        TreeNode leftNode = helper(root.left, target);
        TreeNode rightNode = helper(root.right, target);

        if (leftNode != null && leftNode.left == null && leftNode.right == null && leftNode.val == target) root.left = null;
        if (rightNode != null && rightNode.left == null && rightNode.right == null && rightNode.val == target) root.right = null;

        return root;
    }
}
