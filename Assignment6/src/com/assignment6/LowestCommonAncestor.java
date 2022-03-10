package com.assignment6;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {
    HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        createParentMap(root, p, q);
        HashSet<TreeNode> path = new HashSet<>();
        while (p != root) {
            path.add(p);
            p = parentMap.get(p);
        }
        path.add(root);

        while (!path.contains(q)) {
            q = parentMap.get(q);
        }

        return q;
    }

    private void createParentMap(TreeNode root, TreeNode p, TreeNode q) {
        if (parentMap.containsKey(p) && parentMap.containsKey(q)) return;
        if (root == null) return;

        if (root.left != null) parentMap.put(root.left, root);
        if (root.right != null) parentMap.put(root.right, root);

        createParentMap(root.left, p, q);
        createParentMap(root.right, p, q);
    }
}
