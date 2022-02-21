package com.leetcode.ReverseInteger;

public class Solution {

    /*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
    the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.*/

    public static void main(String[] args) {
        assertion(reverse(Integer.MAX_VALUE), 0);
        assertion(reverse(123), 321);
        assertion(reverse(64345242), 24254346);
        assertion(reverse(5554), 4555);
        assertion(reverse(65567), 76556);
        assertion(reverse(11111), 11111);
        assertion(reverse(0), 0);
        assertion(reverse(-321), -123);
        assertion(reverse(Integer.MIN_VALUE), 0);
    }

    public static int reverse(int x) {
        boolean isNegative = x < 0;
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        sb.reverse();
        try {
            return isNegative ? -1*Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
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
