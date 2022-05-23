package com.leetcode.StringToIntegeratoi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {

    /*Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

            The algorithm for myAtoi(string s) is as follows:

    Read in and ignore any leading whitespace.
            Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
    Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
    Return the integer as the final result.

            Note:

    Only the space character ' ' is considered a whitespace character.
    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.*/


    public static void main(String[] args) {
        assertion(myAtoi("   -42"), -42);
        assertion(myAtoi("42"), 42);
        assertion(myAtoi("4193 with words"), 4193);
        assertion(myAtoi("bla blabla? -991235 bla bla!"), 0);
        assertion(myAtoi(""), 0);
        assertion(myAtoi("words and 987"), 0);
        assertion(myAtoi("-4193 with words"), -4193);
        assertion(myAtoi(String.valueOf(Integer.MAX_VALUE)), Integer.MAX_VALUE);
        assertion(myAtoi(String.valueOf(Integer.MIN_VALUE)), Integer.MIN_VALUE);
        assertion(myAtoi("9999999999999999999999"), Integer.MAX_VALUE);
        assertion(myAtoi("-9999999999999999999999"), Integer.MIN_VALUE);
        assertion(myAtoi("3.14159"), 3);
        assertion(myAtoi("-+12"), 0);
        assertion(myAtoi("-"), 0);
    }

    public static int myAtoi(String s) {
        boolean isNeg = false;
        try {
            if (s.isEmpty() || s.equals("-")) {
                return 0;
            }
            s = s.trim();
            ArrayList<Character> allowed = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'));
            for (int i = 0; i < s.length(); i++) {
                if (String.valueOf(s.charAt(i)).matches("\\d")) {
                    break;
                } else if (!allowed.contains(s.charAt(i))) {
                    return 0;
                }
            }
            String s1 = s.split("\\.")[0].replaceAll("\\D", "");
            if (s.contains("-")) {
                isNeg = s.charAt(s.indexOf(s1.charAt(0)) - 1) == '-';
            }
            return isNeg ? -1*Integer.parseInt(s1) : Integer.parseInt(s1);
        } catch (NumberFormatException e) {
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
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
