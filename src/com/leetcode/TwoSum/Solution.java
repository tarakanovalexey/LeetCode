package com.leetcode.TwoSum;

public class Solution {
    /*Given an array of integers nums and an integer target, return indices of the two numbers such
    that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.*/

    public static void main(String[] args) {
        //assertion(twoSum(new int[]{10,15,20}, 30), new int[]{0,2});
        //assertion(twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});
        //assertion(twoSum(new int[]{-1,-2,-3,-4,-5}, -8), new int[]{2,4});
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (target == nums[j-i]+nums[j]) {
                    return new int[]{j-i,j};
                }
            }
        }
        return new int[]{-1,-1};
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
