package com.leetcode.ImplementstrStr;

public class Solution {
    /*Implement strStr().

    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1
    if needle is not part of haystack.

    Clarification:

    What should we return when needle is an empty string? This is a great question to ask during an interview.

    For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr()
    and Java's indexOf().*/

    public static void main(String[] args) {
        assertion(strStr("aaaaa", "bba"), -1);
        assertion(strStr("aaaaa", "a"), 0);
        assertion(strStr("hello", "ll"), 2);
        assertion(strStr("abccas", "cca"), 2);
        assertion(strStr("abccas", ""), 0);
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
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
