package com.leetcode.LengthOfLastWord;

public class Solution {

    public static void main(String[] args) {
        assertion(getLastWordLength("I like to swim   "), 4);
        assertion(getLastWordLength("Do u 123?"), 4);
        assertion(getLastWordLength("  I   DONT K N O W   "), 1);
        assertion(getLastWordLength(" "), 0);
        assertion(getLastWordLength(""), 0);
    }

    public static int getLastWordLength(String str) {
        int c = 0;
        str = str.trim();
        for (int i = str.length()-1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                c++;
            } else {
                return c;
            }
        }
        return c;
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
