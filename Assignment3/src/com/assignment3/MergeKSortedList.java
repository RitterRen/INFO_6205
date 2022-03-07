package com.assignment3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    // T/S = O(nlogn) / O(n)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        for (ListNode p: lists) {
            if (p != null)
                pq.add(p);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while (pq.size() > 0) {
            ListNode temp = pq.poll();
            p.next = temp;
            p = p.next;

            if (temp.next != null) {
                pq.add(temp.next);
            }
        }

        return dummyHead.next;
    }
}
