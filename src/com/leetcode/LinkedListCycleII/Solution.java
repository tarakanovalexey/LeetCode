package com.leetcode.LinkedListCycleII;

import java.util.HashMap;

public class Solution {
    /*Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
    connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

    Do not modify the linked list.*/

    public static void main(String[] args) {
        ListNode l3 = new ListNode(0);
        ListNode l2 = new ListNode(2, l3);
        ListNode l4 = new ListNode(-4, l2);
        ListNode l1 = new ListNode(3, l2);
        l3.next = l4;
        assertion(middleNode(l1), l2);
        /*ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        l1.next = l2;
        assertion(middleNode(l1), l1);*/
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<String, ListNode> map = new HashMap<>();
        while (true) {
            if (map.containsKey(head.toString())) {
                return map.get(head.toString());
            } else {
                map.put(head.toString(), head);
            }
            if (head.next == null) {
                return null;
            } else {
                head = head.next;
            }
        }
    }

    public static class ListNode {
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

    private static boolean assertion(Object result, Object expectedValue) {
        return result.equals(expectedValue) ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(Object result, Object expectedValue) {
        System.out.println("\u001B[31m" + "Failed: expected " + expectedValue.toString() + ", got " + result.toString());
        return true;
    }

    private static boolean printSuccess(Object result, Object expectedValue) {
        System.out.println("\u001B[32m" + "Success: expected " + expectedValue.toString() + ", got " + result.toString());
        return false;
    }
}
