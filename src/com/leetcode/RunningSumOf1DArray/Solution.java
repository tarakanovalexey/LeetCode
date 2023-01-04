package com.leetcode.RunningSumOf1DArray;

import java.util.Arrays;
import java.util.Objects;

public class Solution {
    /*Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.*/

    public static void main(String[] args) {
        assertion(runningSum(new int[]{1,2,3}), new int[]{1,3,6});
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }

    private static boolean assertion(Object result, Object expectedValue) {
        return Arrays.equals((int[]) result, (int[]) expectedValue) ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
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
