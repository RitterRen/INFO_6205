package com.assignment6;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class PathSum3 {
    int result = 0;
    HashMap<Integer, Integer> valueMap = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        valueMap.put(0, 1);
        preorderTraverse(root, root.val, targetSum);

        return result;
    }

    private void preorderTraverse(TreeNode root, int preSum, int target) {

        if (valueMap.containsKey(preSum - target)) result += valueMap.get(preSum - target);
        valueMap.put(preSum, valueMap.getOrDefault(preSum, 0) + 1);

        if (root.left != null) preorderTraverse(root.left, preSum + root.left.val, target);
        if (root.right != null) preorderTraverse(root.right, preSum + root.right.val, target);

        // backTrack
        valueMap.put(preSum, valueMap.getOrDefault(preSum, 0) - 1);
    }

    private void putInMap(int key) {
        if (!valueMap.containsKey(key)){
            valueMap.put(key, 1);
        }else {
            valueMap.put(key, valueMap.get(key) + 1);
        }
    }
}
