package com.leetcode.LongestPalindrome;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
    that can be built with those letters.

    Letters are case-sensitive, for example,"Aa" is not considered a palindrome here.*/

    public static void main(String[] args) {
        assertion(longestPalindrome("abccccdd"), 7);
        assertion(longestPalindrome("a"), 1);
    }

    public static int longestPalindrome(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        int m;
        boolean hasOne = false;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            m = e.getValue() / 2;
            e.setValue(e.getValue() - m * 2);
            result += m * 2;
            if (e.getValue() == 1) {
                hasOne = true;
            }
        }
        return result + (hasOne ? 1 : 0);
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
