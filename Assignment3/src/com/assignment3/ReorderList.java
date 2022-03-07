package com.assignment3;

import java.util.ArrayList;

public class ReorderList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public void reorderList(ListNode head) {
        // using ArrayList
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode p = head;

        while (p != null) {
            arr.add(p.val);
            p = p.next;
        }

        // Double Pointer
        if (arr.size() <= 1) return;

        int left = 1;
        int right = arr.size() - 1;
        p = head;
        int index = 0;

        while (left <= right) {
            if (index % 2 == 0) {
                p.next.val = arr.get(right);
                right--;
            }else {
                p.next.val = arr.get(left);
                left++;
            }
            index++;
            p = p.next;
        }

    }
}
