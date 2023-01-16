package com.leetcode.BackspaceStringCompare;

public class Solution {
    /*Given two strings s and t, return true if they are equal when both are typed into empty text editors.
    '#' means a backspace character.

    Note that after backspacing an empty text, the text will continue empty.*/

    public static void main(String[] args) {
        assertion(backspaceCompare("ab#c", "ad#c"), true);
        assertion(backspaceCompare("ab##", "c#d#"), true);
        assertion(backspaceCompare("a#c", "b"), false);
        assertion(backspaceCompare("a##c", "#a#c"), false);
    }

    public static boolean backspaceCompare(String s, String t) {
        StringBuilder sbS = new StringBuilder(s);
        StringBuilder sbT = new StringBuilder(t);
        removeHash(sbS);
        removeHash(sbT);
        return sbS.toString().equals(sbT.toString());
    }

    public static void removeHash(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '#' && i == 0) {
                sb.deleteCharAt(i);
                i--;
                continue;
            }
            if (sb.charAt(i) == '#') {
                i--;
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i--;
            }
        }
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
