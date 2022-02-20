package com.leetcode.LongestCommonPrefix;

public class Solution {
    public static void main(String[] args) {
        assertion(longestCommonPrefix(new String[]{"flower","flow","flight"}), "fl");
    }

    public static String longestCommonPrefix(String[] strs) {
        return "";
    }

    private static boolean assertion(String result, String expectedValue) {
        return result == expectedValue ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(String result, String expectedValue) {
        System.out.println("\u001B[31m"+"Failed: expected "+expectedValue+", got "+result);
        return true;
    }

    private static boolean printSuccess(String result, String expectedValue) {
        System.out.println("\u001B[32m"+"Success: expected "+expectedValue+", got "+result);
        return false;
    }
}
