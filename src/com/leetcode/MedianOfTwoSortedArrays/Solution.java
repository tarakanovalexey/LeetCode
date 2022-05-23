package com.leetcode.MedianOfTwoSortedArrays;

public class Solution {

    /*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

    The overall run time complexity should be O(log (m+n)).*/

    public static void main(String[] args) {
        assertion(findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 2d);
        assertion(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), 2.5d);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 2d;
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
