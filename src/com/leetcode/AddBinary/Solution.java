package com.leetcode.AddBinary;

public class Solution {

    public static void main(String[] args) {
        assertion(addBinary("111", "1"), "1000");
        assertion(addBinary("1", "1"), "10");
        assertion(addBinary("1", "0"), "1");
        assertion(addBinary("111", "100"), "1011");
        assertion(addBinary("1", "1001"), "1010");
        assertion(addBinary("10000", "1"), "10001");
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int length = Math.max(a.length(), b.length());
        boolean addFromPrev = false;
        for (int i = 0; i < length; i++) {
            char aChar;
            try {
                aChar = a.charAt(i);
            } catch (Exception e) {
                aChar = '0';
            }
            char bChar;
            try {
                bChar = b.charAt(i);
            } catch (Exception e) {
                bChar = '0';
            }
            if (aChar == '0' && bChar == '0') {
                if (addFromPrev) {
                    result.append("1");
                    addFromPrev = false;
                } else {
                    result.append("0");
                }
            } else if (aChar == '0' || bChar == '0') {
                if (addFromPrev) {
                    result.append("0");
                } else {
                    result.append("1");
                }
            } else {
                if (addFromPrev) {
                    result.append("1");
                } else {
                    result.append("0");
                    addFromPrev = true;
                }
            }
        }
        if (addFromPrev) {
            result.append("1");
        }
        return result.reverse().toString();
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
