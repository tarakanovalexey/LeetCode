package com.leetcode.LongestCommonPrefix;

public class Solution {
    /*Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".*/

    public static void main(String[] args) {
        assertion(longestCommonPrefix(new String[]{"flower","flow","flight"}), "fl");
        assertion(longestCommonPrefix(new String[]{"dog","racecar","car"}), "");
        assertion(longestCommonPrefix(new String[]{"a"}), "a");
        assertion(longestCommonPrefix(new String[]{"reflower","flow","flight"}), "");
        assertion(longestCommonPrefix(new String[]{"c","acc","ccc"}), "");
        assertion(longestCommonPrefix(new String[]{"ab", "a"}), "a");
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        boolean exit = false;
        for (int i = 0; i < strs[0].length(); i++) {
            sb.append(strs[0].charAt(i));
            for (String s : strs) {
                if (s.length()-1 < i || s.charAt(i) != sb.charAt(sb.length()-1)) {
                    sb.deleteCharAt(sb.length()-1);
                    exit = true;
                    break;
                }
            }
            if (exit) {
                break;
            }
        }
        return sb.toString();
    }

    private static boolean assertion(String result, String expectedValue) {
        return result.equals(expectedValue) ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(String result, String expectedValue) {
        System.out.println("\u001B[31m"+"Failed: expected "+(expectedValue.isEmpty()?"isEmpty":expectedValue)+", got "+(result.isEmpty()?"isEmpty":result));
        return true;
    }

    private static boolean printSuccess(String result, String expectedValue) {
        System.out.println("\u001B[32m"+"Success: expected "+(expectedValue.isEmpty()?"isEmpty":expectedValue)+", got "+(result.isEmpty()?"isEmpty":result));
        return false;
    }
}
