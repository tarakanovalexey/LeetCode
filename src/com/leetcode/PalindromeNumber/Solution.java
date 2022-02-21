package com.leetcode.PalindromeNumber;

public class Solution {
    public static void main(String[] args) {
        assertion(isPalindrome(121), true);
        assertion(isPalindrome(123), false);
        assertion(isPalindrome(12321), true);
        assertion(isPalindrome(12328), false);
        assertion(isPalindrome(123321), true);
        assertion(isPalindrome(77477), true);
        assertion(isPalindrome(774577), false);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        String text = String.valueOf(x);
        for (int i = 0; i < text.length()/2; i++) {
            if (text.charAt(i) != text.charAt(text.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean assertion(boolean result, boolean expectedValue) {
        return result == expectedValue ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(boolean result, boolean expectedValue) {
        System.out.println("\u001B[31m"+"Failed: expected "+expectedValue+", got "+result);
        return true;
    }

    private static boolean printSuccess(boolean result, boolean expectedValue) {
        System.out.println("\u001B[32m"+"Success: expected "+expectedValue+", got "+result);
        return false;
    }
}
