package com.assignment6;

import java.util.*;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<int[]>> result = new HashMap<>();
        verticalTraversalHelper(root, result, 0, 0);

        //System.out.println(result.toString());

        int minVertical = getMinInArray(result.keySet());
        int maxVertical = getMaxInArray(result.keySet());
        List<List<Integer>> aws = new ArrayList<>();

        for (int key = minVertical; key <= maxVertical; key++) {
            if (result.containsKey(key)) {
                Collections.sort(result.get(key), new Comparator<int[]>(){
                    public int compare(int[] o1, int[] o2) {
                        if (o1[1] != o2[1]) return o2[1] - o1[1];
                        return o1[0] - o2[0];
                    }
                });
                List<Integer> temp = new ArrayList<>();
                for (int[] item: result.get(key)) {
                    temp.add(item[0]);
                }
                aws.add(temp);
            }
        }

        return aws;
    }

    private void verticalTraversalHelper(TreeNode root, HashMap<Integer, List<int[]>> result, int vertical, int height) {
        if (root == null) return;

        if (!result.containsKey(vertical)) result.put(vertical, new ArrayList<>());
        result.get(vertical).add(new int[]{root.val, height});

        verticalTraversalHelper(root.left, result, vertical - 1, height - 1);
        verticalTraversalHelper(root.right, result, vertical + 1, height - 1);
    }

    private int getMinInArray(Set<Integer> list) {
        int result = Integer.MAX_VALUE;

        for (int num: list) {
            result = Math.min(result, num);
        }

        return result;
    }

    private int getMaxInArray(Set<Integer> list) {
        int result = Integer.MIN_VALUE;

        for (int num: list) {
            result = Math.max(result, num);
        }

        return result;
    }
}
