package com.assignment3;

import java.util.ArrayList;

public class NextGreaterNodeinLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = head;
        ArrayList<Integer> result = new ArrayList<>();

        while (p != null) {
            ListNode q = p.next;
            while (q != null) {
                if (q.val > p.val){
                    result.add(q.val);
                    break;
                }
                q = q.next;
            }
            if (q == null) {
                result.add(0);
            }
            p = p.next;
        }

        return arrayListToArray(result);
    }

    private int[] arrayListToArray(ArrayList<Integer> arr) {
        int[] result = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }

        return result;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
