package com.assignment6;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        //System.out.println(sb.toString());

        return sb.toString().trim();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }

        sb.append(Integer.toString(root.val) + " ");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> dq = new LinkedList<>();
        dq.addAll(Arrays.asList(data.split(" ")));
        //System.out.println(dq.toString());
        return deserializeHelper(dq);

    }

    private TreeNode deserializeHelper(Deque<String> dq) {
        if (dq.size() == 0) return null;
        //System.out.println(dq.toString());
        if (dq.peekFirst().equals("#")) {
            dq.pollFirst();
            return null;
        }
        //System.out.println(index);
        TreeNode root = new TreeNode(Integer.parseInt(dq.pollFirst()));
        root.left = deserializeHelper(dq);
        root.right = deserializeHelper(dq);

        return root;
    }
}
