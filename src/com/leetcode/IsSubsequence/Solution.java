package com.leetcode.IsSubsequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by deleting
    some (can be none) of the characters without disturbing the relative positions of the remaining characters.
     (i.e., "ace" is a subsequence of "abcde" while "aec" is not).*/

    public static void main(String[] args) {
        assertion(isSubsequence("abc", "ahbgdc"), true);
        assertion(isSubsequence("axc", "ahbgdc"), false);
        assertion(isSubsequence("", "ahbgdc"), true);
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
            if (j == s.length()) {
                return true;
            }
        }
        return false;
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
