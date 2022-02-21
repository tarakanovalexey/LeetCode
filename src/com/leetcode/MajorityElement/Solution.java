package com.leetcode.MajorityElement;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    /*Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.*/

    public static void main(String[] args) {
        assertion(majorityElement(new int[]{3,2,3}), 3);
        assertion(majorityElement(new int[]{2,2,1,1,1,2,2}), 2);
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i-1] != nums[i]) {
                count = 1;
            } else {
                count++;
            }
            if (count > nums.length/2) {
                return nums[i];
            }
        }
        return 0;
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
