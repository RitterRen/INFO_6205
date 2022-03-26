package com.BinarySearchTree;

import java.util.HashSet;

public class BinarySearchTree {
    public TreeNode root = null;
    public HashSet<Integer> visited = new HashSet<>(); // make sure no duplicate value;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            visited.add(value);
            return;
        }

        if (visited.contains(value)) return;

        TreeNode parent = null;
        TreeNode current = root;
        visited.add(value);

        while (true) {
            parent = current;
            if (value > current.val) {
                current = current.right;

                if (current == null) {
                    parent.right = new TreeNode(value);
                    return;
                }
            }else if (value < current.val) {
                current = current.left;

                if (current == null) {
                    parent.left = new TreeNode(value);
                    return;
                }
            }else {
                break;
            }
        }
    }

    public void printTree() {
        TreeNode p = root;

        printHelper(p);
    }

    private void printHelper(TreeNode p) {
        if (p == null) {
            return;
        }

        printHelper(p.left);
        System.out.print(p.val + " ");
        printHelper(p.right);
    }
}
