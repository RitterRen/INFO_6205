package com.assignment4;

public class SplitLinkedListPart {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int length = getLinkedListSize(head);
        int portion = length / k;
        int remain = length % k;
        ListNode p = head;
        int i = 0;

        while (p != null) {
            ListNode q = p;
            int tempPortion = portion;
            if (remain > 0) {
                tempPortion++;
                remain--;
            }
            while (tempPortion > 1) {
                q = q.next;
                tempPortion--;
            }
            ListNode temp = q.next;
            q.next = null;
            result[i++] = p;
            p = temp;
        }

        if (i < result.length) {
            result[i++] = null;
        }

        return result;
    }

    private int getLinkedListSize(ListNode head) {
        int size = 0;
        ListNode p = head;

        while (p != null) {
            size++;
            p = p.next;
        }

        return size;
    }
}
