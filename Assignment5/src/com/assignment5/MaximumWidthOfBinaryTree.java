package com.assignment5;

import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair<TreeNode, Integer>> deque = new LinkedList<>();
        Pair<TreeNode, Integer> pair = new Pair<>(root, 0); // {root, index}
        deque.add(pair);
        int result = 0;

        while (deque.size() > 0) {
            int length = deque.size();
            int leftVal = 0;
            int rightVal = 0;
            for (int i = 0; i < length; i++) {
                Pair<TreeNode, Integer> temp = deque.pollFirst();
                TreeNode node = temp.getKey();
                int value = temp.getValue();

                if (i == 0) {
                    leftVal = value;
                }
                if (i == length - 1) {
                    rightVal = value;
                }
                if (node.left != null) {
                    Pair<TreeNode, Integer> tempPair = new Pair<>(node.left, value * 2);
                    deque.add(tempPair);
                }
                if (node.right != null) {
                    Pair<TreeNode, Integer> tempPair = new Pair<>(node.right, value * 2 + 1);
                    deque.add(tempPair);
                }
            }
            if (leftVal != rightVal) {
                result = Math.max(rightVal - leftVal + 1, result);
            }else {
                result = Math.max(result, 1);
            }
        }

        return result;
    }
}
