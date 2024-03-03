package com.sundance.leetcode.solutions.add_two_numbers;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode next1 = l1;
        ListNode next2 = l2;
        ListNode next3 = l3;
        boolean hasNext1 = Objects.nonNull(l1);
        boolean hasNext2 = Objects.nonNull(l2);
        boolean hasRemainder = false;
        boolean run = hasNext1 || hasNext2;

        while (run) {
            int sum = hasRemainder ? 1 : 0;

            if (hasNext1) {
                sum += next1.val;
                next1 = next1.next;
            } else {
                next1 = null;
            }

            if (hasNext2) {
                sum += next2.val;
                next2 = next2.next;
            } else {
                next2 = null;
            }

            hasRemainder = sum > 9;

            next3.val = hasRemainder ? sum - 10 : sum;

            hasNext1 = Objects.nonNull(next1);
            hasNext2 = Objects.nonNull(next2);
            run = hasNext1 || hasNext2;
            if (run) {
                next3.next = new ListNode();
                next3 = next3.next;
                continue;
            }
            if (hasRemainder) {
                next3.next = new ListNode(1);
            }
        }

        return l3;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
