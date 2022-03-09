package com.assignment5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        // postorder traverse
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        postTraverse(root, result);

        //System.out.println(result.toString());

        List<List<Integer>> aws = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            aws.add(result.get(i));
        }

        return aws;
    }

    private int postTraverse(TreeNode root, HashMap<Integer, List<Integer>> result) {
        if (root == null) return 0;

        int leftDepth = postTraverse(root.left, result);
        int rightDepth = postTraverse(root.right, result);
        int currentDepth = Math.max(leftDepth, rightDepth);

        if (!result.containsKey(currentDepth)) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.put(currentDepth, temp);
        }else {
            result.get(currentDepth).add(root.val);
        }

        return currentDepth + 1;
    }
}
