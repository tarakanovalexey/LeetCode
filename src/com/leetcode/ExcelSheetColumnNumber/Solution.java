package com.leetcode.ExcelSheetColumnNumber;

public class Solution {

    public static void main(String[] args) {
        assertion(titleToNumber("A"), 1);
        assertion(titleToNumber("B"), 2);
        assertion(titleToNumber("C"), 3);
        assertion(titleToNumber("Z"), 26);
        assertion(titleToNumber("AA"), 27); // A = 1; 26*1 = 26; 26 + 1 = 27;
        assertion(titleToNumber("AB"), 28); // A = 1; 26*1 = 26; 26 + 2 = 28;
        assertion(titleToNumber("BA"), 53); // B = 2; 26*2 = 52; 52 + 1 = 53;
        assertion(titleToNumber("BB"), 54); // B = 2; 26*2 = 52; 52 + 2 = 54;
        assertion(titleToNumber("AAA"), 703); // A = 1; 26*26*1 = 676; 26*1 = 26; 1;
        assertion(titleToNumber("ZY"), 701); // Z = 26; Y = 25; 26*26 = 676; 676 + 25 = 701
        assertion(titleToNumber("ZZY"), 18277); // Z = 26; 26^3 = 17576; 26^2 = 676; +25 = 18277
        assertion(titleToNumber("FXSHRXW"), 2147483647);
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            if (i == columnTitle.length()-1) {
                result += ((int) columnTitle.charAt(i) - 64);
            } else {
                result += ((int) columnTitle.charAt(i) - 64)*Math.pow(26,columnTitle.length()-1-i);
            }
        }
        return result;
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
