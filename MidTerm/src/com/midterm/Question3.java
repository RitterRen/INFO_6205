package com.midterm;
import com.midterm.TreeNode;

public class Question3 {
    public static void main(String[] args) {

    }

    public static TreeNode question3(int[] preorder, int[] inorder){
        if (preorder == null || inorder == null) return null;
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int[] inorder, int preLeftSide, int preRightSide, int inLeftSide, int inRightSide) {
        if (preLeftSide > preRightSide || inLeftSide > inRightSide) return null;

        TreeNode root = new TreeNode(preorder[preLeftSide]);
        int loc = inLeftSide;

        for (int i = inLeftSide; i <= inRightSide; i++) {
            if (preorder[preLeftSide] == inorder[i]) {
                loc = i;
                break;
            }
        }

        root.left = helper(preorder, inorder, preLeftSide + 1, preLeftSide + loc - inLeftSide, inLeftSide, loc - 1);
        root.right = helper(preorder, inorder, preLeftSide + loc - inLeftSide + 1, preRightSide, loc + 1, inRightSide);

        return root;
    }
}
