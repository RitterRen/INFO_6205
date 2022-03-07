package com.assignment3;

public class OddEvenLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        // Double Pointer
        ListNode oddp = head;
        ListNode evenp = head.next;
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;

        while (oddp != null) {
            p.next = new ListNode(oddp.val);
            p = p.next;
            if (oddp.next != null) {
                oddp = oddp.next.next;
            }else {
                break;
            }
        }

        while (evenp != null) {
            p.next = new ListNode(evenp.val);
            p = p.next;
            if (evenp.next != null) {
                evenp = evenp.next.next;
            }else {
                break;
            }
        }

        return dummyHead.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
