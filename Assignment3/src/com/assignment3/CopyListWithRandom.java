package com.assignment3;

import org.w3c.dom.Node;

public class CopyListWithRandom {

    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(0);
        Node p2 = dummyHead;
        Node p1 = head;

        while (p1 != null) {
            p2.next = new Node(p1.val);
            p1 = p1.next;
            p2 = p2.next;
        }

        p1 = head;
        p2 = dummyHead.next;

        while (p2 != null) {
            int i = findIndex(p1.random, head);

            if (i == -1) {
                p2.random = null;
            } else {
                p2.random = getIndexNode(i, dummyHead.next);
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return dummyHead.next;
    }

    // T/S = O(listNode.size) / O(1)
    private static int findIndex(Node target, Node head) {
        Node p = head;
        int result = 0;
        if (target == null) return -1;

        while (p != null) {
            if (p == target) {
                return result;
            }
            p = p.next;
            result++;
        }

        return result;
    }

    // T/S = O(listNode2.size) / O(1)
    private static Node getIndexNode(int index, Node head) {
        Node p = head;

        while (index > 0) {
            p = p.next;
            index--;
        }

        return p;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Best solution Time complexity: O(n);
    public Node copyRandomList2(Node head) {
        Node p = head;

        while (p != null) {
            Node tempNode = new Node(p.val);
            tempNode.next = p.next;
            p.next = tempNode;
            p = p.next.next;
        }

        p = head;

        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        Node dummyHead = new Node(0);
        p = head;
        Node q = dummyHead;

        while (p != null && p.next != null) {
            q.next = p.next;
            p.next = p.next.next;
            p = p.next;
            q = q.next;
        }

        return dummyHead.next;
    }
}

