package com.assignment4;

import java.util.ArrayList;
import java.util.Random;

public class LinkedListRandomNode {
    ArrayList<Integer> nums = new ArrayList<>();

    public void Solution(ListNode head) {
        ListNode p = head;
        while (p != null) {
            nums.add(p.val);
            p = p.next;
        }
    }

    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(nums.size());
        return nums.get(index);
    }
}
