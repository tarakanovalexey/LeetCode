package com.leetcode.BinarySearch;

public class Solution {
    /*Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
    to search target in nums. If target exists, then return its index. Otherwise, return -1.

    You must write an algorithm with O(log n) runtime complexity.*/

    public static void main(String[] args) {
        assertion(search(new int[]{-1,0,3,5,9,12}, 9), 4);
        assertion(search(new int[]{-1,0,3,5,9,12}, 2), -1);
    }

    public static int search(int[] nums, int target) {
        int firstIndex = 0;
        int lastIndex = nums.length - 1;
        while (true) {
            if (lastIndex - firstIndex <= 1) {
                if (nums[lastIndex] == target) {
                    return lastIndex;
                } else if (nums[firstIndex] == target) {
                    return firstIndex;
                } else {
                    return -1;
                }
            }
            if (nums[(lastIndex+firstIndex+1)/2] < target) {
                firstIndex = (lastIndex+firstIndex+1)/2;
            } else if (nums[(lastIndex+firstIndex+1)/2] > target) {
                lastIndex = (lastIndex+firstIndex+1)/2;
            } else {
                return (lastIndex+firstIndex+1)/2;
            }
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
