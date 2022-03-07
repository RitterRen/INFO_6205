package com.assignment3;

public class InsertIntoASortedLinkedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node pre = head;
        Node cur = head.next;

        while (cur != head) {
            if (pre.val <= insertVal && cur.val >= insertVal) break;
            if (pre.val > cur.val && (insertVal >= pre.val || cur.val >= insertVal)) break;
            pre = cur;
            cur = cur.next;
        }

        insertNode(pre, insertVal);

        return head;
    }

    private void insertNode(Node start, int insertVal) {
        Node newNode = new Node(insertVal);
        newNode.next = start.next;
        start.next = newNode;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
