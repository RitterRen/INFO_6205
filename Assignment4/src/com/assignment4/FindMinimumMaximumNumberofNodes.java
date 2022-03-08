package com.assignment4;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMinimumMaximumNumberofNodes {
    public static void main(String[] args) {
        int[] testCase1 = {5,3,1,2,5,1,2};
        ListNode head1 = new ListNode(testCase1[0]);
        ListNode p = head1;

        for (int i = 1; i < testCase1.length; i++) {
            p.next = new ListNode(testCase1[i]);
            p = p.next;
        }

        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head1)));

    }
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
//         if (head == null || head.next == null || head.next.next == null){
//             int[] result = {-1, -1};
//             return result;
//         }

        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode post = cur.next;
        int index = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        while (post != null) {
            index++;
            if ((cur.val > post.val && cur.val > pre.val) || (cur.val < post.val && cur.val < pre.val) ) {
                arr.add(index);
            }

            pre = cur;
            cur = post;
            post = post.next;
        }

        // System.out.println(arr.toString());
        if (arr.size() < 2) {
            int[] result = {-1, -1};
            return result;
        }

        int minDis = Integer.MAX_VALUE;
        int maxDis = arr.get(arr.size() - 1) - arr.get(0);
        int[] result = new int[2];

        for (int i = 0; i < arr.size() - 1; i++) {
            minDis = Math.min(minDis, arr.get(i + 1) - arr.get(i));
        }
        result[0] = minDis;
        result[1] = maxDis;

        return result;
    }
}
