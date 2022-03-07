package com.assignment3;

import java.util.ArrayList;
import java.util.Objects;

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public boolean isPalindrome(ListNode head) {
        // ArrayList
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode p = head;

        while (p != null) {
            arr.add(p.val);
            p = p.next;
        }

        int left = 0;
        int right = arr.size() - 1;
        //boolean flag = true;
        while (left < right) {
            if (!Objects.equals(arr.get(left), arr.get(right))) return false;
            left++;
            right--;
        }

        return true;
    }

    // Time Complexity: O(n), Space Complexity: O(1);
    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = reverseLinkedList(slow);
        //System.out.println(head2.val);
        ListNode p1 = head;
        ListNode p2 = head2;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
