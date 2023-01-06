package com.leetcode.MiddleOfTheLinkedList;

import java.util.ArrayList;

public class Solution {
    /*Given the head of a singly linked list, return the middle node of the linked list.

    If there are two middle nodes, return the second middle node.*/

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = new ListNode(3, new ListNode(4, new ListNode(5)));
        assertion(middleNode(node), result);
    }

    public static ListNode middleNode(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (true) {
            list.add(head);
            if (head.next != null) {
                head = head.next;
            } else {
                break;
            }
        }
        return list.get(list.size()/2);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ListNode)) return false;

            ListNode listNode = (ListNode) o;

            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return val;
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
