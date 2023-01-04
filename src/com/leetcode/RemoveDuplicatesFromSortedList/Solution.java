package com.leetcode.RemoveDuplicatesFromSortedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
    /*Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     Return the linked list sorted as well.*/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode l2 = new ListNode(1, new ListNode(2));
        assertion(deleteDuplicates(l1), l2);
        l1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        l2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        assertion(deleteDuplicates(l1), l2);
        l1 = null;
        l2 = null;
        assertion(deleteDuplicates(l1), l2);
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
            return Objects.hash(val);
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode;
        while (true) {
            if (currentNode == null || currentNode.next == null) {
                break;
            } else {
                nextNode = currentNode.next;
            }
            if (nextNode.val == currentNode.val) {
                currentNode.next = nextNode.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
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
