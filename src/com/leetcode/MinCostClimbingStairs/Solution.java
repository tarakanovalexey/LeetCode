package com.leetcode.MinCostClimbingStairs;

public class Solution {
    /*You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
    Once you pay the cost, you can either climb one or two steps.

    You can either start from the step with index 0, or the step with index 1.

    Return the minimum cost to reach the top of the floor.

    Constraints:

    2 <= cost.length <= 1000
    0 <= cost[i] <= 999*/

    public static void main(String[] args) {
        assertion(minCostClimbingStairs(new int[]{10,15,20}), 15);
        assertion(minCostClimbingStairs(new int[]{1,15,1}), 2);
        assertion(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}), 6);
        assertion(minCostClimbingStairs(new int[]{10, 1}), 1);
        assertion(minCostClimbingStairs(new int[]{1, 10}), 1);
        assertion(minCostClimbingStairs(new int[]{0, 1, 2, 1}), 2);
        assertion(minCostClimbingStairs(new int[]{0, 1, 2, 2}), 2);
    }

    public static int minCostClimbingStairs(int[] cost) {
        boolean canSkip = true;
        int result = 0;
        for (int i = 0; i < cost.length; i++) {
            result += cost[i];
        }
        return result;
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
