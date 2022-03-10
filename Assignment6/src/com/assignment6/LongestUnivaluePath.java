package com.assignment6;

public class LongestUnivaluePath {
    int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;

        postorderTraverse(root);

        return result == 0 ? 0 : result - 1;
    }

    public int postorderTraverse(TreeNode root) {
        if (root == null) return 0;

        int leftSide = postorderTraverse(root.left);
        int rightSide = postorderTraverse(root.right);

        if (root.left != null && root.val == root.left.val && root.right != null && root.val == root.right.val) {
            result = Math.max(1 + leftSide + rightSide, result);
            return Math.max(1 + leftSide, 1 + rightSide);
        }else if (root.left != null && root.val == root.left.val) {
            result = Math.max(1 + leftSide, result);
            return 1 + leftSide;
        }else if (root.right != null && root.val == root.right.val) {
            result = Math.max(1 + rightSide, result);
            return 1 + rightSide;
        }

        return 1;
    }
}
