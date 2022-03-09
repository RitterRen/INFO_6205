package com.assignment5;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (deque.size() > 0) {
            int length = deque.size();
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < length; i++) {
                TreeNode node = deque.pollFirst();
                maxValue = Math.max(maxValue, node.val);

                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }

            result.add(maxValue);
        }

        return result;
    }
}
