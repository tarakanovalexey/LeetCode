package com.leetcode.BestTimeToBuyAndSellStock;

public class Solution {
    /*You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different
    day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.*/

    public static void main(String[] args) {
        assertion(maxProfit(new int[]{7,1,5,3,6,4}), 5);
        assertion(maxProfit(new int[]{7,6,4,3,1}), 0);
        assertion(maxProfit(new int[]{7,6,4,3,1,7}), 6);
        assertion(maxProfit(new int[]{2,4,1}), 2);
    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        int startSum = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (startSum > prices[i] || i == 0) {
                startSum = prices[i];
            } else {
                continue;
            }
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]-prices[i] > result) {
                    result = prices[j]-prices[i];
                }
            }
        }
        return result;
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
