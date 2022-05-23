package com.leetcode.ValidParentheses;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    /*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.*/


    public static void main(String[] args) {
        assertion(isValid("()"), true);
        assertion(isValid("()[]{}"), true);
        assertion(isValid("(}"), false);
        assertion(isValid("({}[])"), true);
        assertion(isValid(""), true);
        assertion(isValid("{{()}}"), true);
        assertion(isValid("({[)})"), false);
        assertion(isValid("({[]}))"), false);
        assertion(isValid("({[]}"), false);
        assertion(isValid("([)]"), false);
    }

    public static boolean isValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ')') {
                if (i == 0 || sb.charAt(i-1) != '(') {
                    return false;
                } else {
                    sb.deleteCharAt(i--);
                    sb.deleteCharAt(i--);
                    continue;
                }
            }
            if (sb.charAt(i) == ']') {
                if (i == 0 || sb.charAt(i-1) != '[') {
                    return false;
                } else {
                    sb.deleteCharAt(i--);
                    sb.deleteCharAt(i--);
                    continue;
                }
            }
            if (sb.charAt(i) == '}') {
                if (i == 0 || sb.charAt(i-1) != '{') {
                    return false;
                } else {
                    sb.deleteCharAt(i--);
                    sb.deleteCharAt(i--);
                }
            }
        }
        return sb.length() == 0;
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
