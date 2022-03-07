package com.assignment3;

public class AddTwoNumber {

     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode dummyHead = new ListNode(0);
            ListNode p = dummyHead;
            int carry = 0;

            while (p1 != null || p2 != null || carry != 0) {
                int val = 0;
                if (p1 != null && p2 != null) {
                    val = p1.val + p2.val + carry;
                    p1 = p1.next;
                    p2 = p2.next;
                }else if (p1 != null) {
                    val = p1.val + carry;
                    p1 = p1.next;
                }else if (p2 != null) {
                    val = p2.val + carry;
                    p2 = p2.next;
                }else {
                    val = carry;
                }

                carry = 0;
                if (val >= 10) {
                    val %= 10;
                    carry = 1;
                }
                p.next = new ListNode(val);
                p = p.next;
            }

            return dummyHead.next;
        }
    }
}
