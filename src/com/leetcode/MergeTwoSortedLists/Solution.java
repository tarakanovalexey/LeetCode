package com.leetcode.MergeTwoSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    /*You are given the heads of two sorted linked lists list1 and list2.

    Merge the two lists in a one sorted list. The list should be made by
    splicing together the nodes of the first two lists.

    Return the head of the merged linked list.*/

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {
        ListNode thirdNode = new ListNode(4);
        ListNode secondNode = new ListNode(2, thirdNode);
        ListNode firstNode = new ListNode(1, secondNode);
        ListNode thirdNode1 = new ListNode(4);
        ListNode secondNode1 = new ListNode(3, thirdNode1);
        ListNode firstNode1 = new ListNode(1, secondNode1);
        ListNode resultNode5 = new ListNode(4);
        ListNode resultNode4 = new ListNode(4, resultNode5);
        ListNode resultNode3 = new ListNode(3, resultNode4);
        ListNode resultNode2 = new ListNode(2, resultNode3);
        ListNode resultNode1 = new ListNode(1, resultNode2);
        ListNode resultNode = new ListNode(1, resultNode1);
        assertion(mergeTwoLists(firstNode, firstNode1), resultNode);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<ListNode> list = new ArrayList<>();
        if (list1 != null) {
            while (true) {
                list.add(list1);
                if (list1.next != null) {
                    list1 = list1.next;
                } else {
                    break;
                }
            }
        }
        if (list2 != null) {
            while (true) {
                list.add(list2);
                if (list2.next != null) {
                    list2 = list2.next;
                } else {
                    break;
                }
            }
        }
        list.sort(Comparator.comparing(o -> o.val));
        for (int i = 0; i < list.size(); i++) {
            if (i+1 < list.size()) {
                list.get(i).next = list.get(i+1);
            }
        }
        return list.isEmpty() ? null : list.get(0);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static boolean assertion(Object result, Object expectedValue) {
        return result.equals(expectedValue) ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(Object result, Object expectedValue) {
        System.out.println("\u001B[31m"+"Failed: expected "+expectedValue+", got "+result);
        return true;
    }

    private static boolean printSuccess(Object result, Object expectedValue) {
        System.out.println("\u001B[32m"+"Success: expected "+expectedValue+", got "+result);
        return false;
    }
}
