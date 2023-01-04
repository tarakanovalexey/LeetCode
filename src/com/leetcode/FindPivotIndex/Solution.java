package com.leetcode.FindPivotIndex;

import java.util.Arrays;

public class Solution {
    /*Given an array of integers nums, calculate the pivot index of this array.

    The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the
    sum of all the numbers strictly to the index's right.

    If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
    This also applies to the right edge of the array.

    Return the leftmost pivot index. If no such index exists, return -1.*/

    public static void main(String[] args) {
        assertion(pivotIndex(new int[]{1,7,3,6,5,6}), 3);
        assertion(pivotIndex(new int[]{1,2,3}), -1);
        assertion(pivotIndex(new int[]{2,1,-1}), 0);
        assertion(pivotIndex(new int[]{-1,-1,0,1,1,0}), 5);
        assertion(pivotIndex(new int[]{-1,-1,0,1,1,-1}), 0);
    }

    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int rightSum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            sum -= nums[i];
            if (i - 1 >= 0) {
                rightSum += nums[i-1];
            }
            if (sum == rightSum) {
                return i;
            }
        }
        if (Arrays.stream(nums).sum() - nums[nums.length-1] == 0) {
            return nums.length-1;
        }
        return -1;
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
