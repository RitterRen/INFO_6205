package com.assignment5;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> aws = new ArrayList<>();
        if (root == null) return aws;
        HashMap<Integer, List<Integer>> result = new HashMap<>();

        postTraverse(root, 0, result);
        //System.out.println(result.toString());
        int depth = 0;
        for (int num: result.keySet()) {
            depth = Math.max(depth, num);
        }


        for (; depth > -1; depth--) {
            aws.add(result.get(depth));
        }

        return aws;
    }

    private static void postTraverse(TreeNode root, int level, HashMap<Integer, List<Integer>> result) {
        if (root == null) return;

        postTraverse(root.left, level + 1, result);
        postTraverse(root.right, level + 1, result);

        if (!result.containsKey(level)) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.put(level, temp);
        }else {
            result.get(level).add(root.val);
        }

    }
}
