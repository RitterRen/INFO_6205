package com.assignment6;

import java.util.LinkedList;

public class SumRootToLeafNumbers {
    LinkedList<String> result = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public int sumNumbers(TreeNode root) {
        sumNumberHelper(root);
        // System.out.println(result.toString());
        int aws = 0;
        for (String s: result) {
            aws += Integer.parseInt(s);
        }

        return aws;
    }

    private void sumNumberHelper(TreeNode root) {
        sb.append(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        }

        if (root.left != null) sumNumberHelper(root.left);
        if (root.right != null) sumNumberHelper(root.right);

        sb.deleteCharAt(sb.length() - 1);
    }
}
