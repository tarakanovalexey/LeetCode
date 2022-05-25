package com.leetcode.SearchInsertPosition;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
    return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.*/

    public static void main(String[] args) {
        assertion(searchInsert(new int[]{2,3,7,8,9}, 7), 2);
        assertion(searchInsert(new int[]{2,3,7,8,9}, 4), 2);
        assertion(searchInsert(new int[]{2,3,4,5,6}, 7), 5);
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    private static boolean assertion(int result, int expectedValue) {
        return result == expectedValue ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(int result, int expectedValue) {
        System.out.println("\u001B[31m"+"Failed: expected "+expectedValue+", got "+result);
        return true;
    }

    private static boolean printSuccess(int result, int expectedValue) {
        System.out.println("\u001B[32m"+"Success: expected "+expectedValue+", got "+result);
        return false;
    }
}
