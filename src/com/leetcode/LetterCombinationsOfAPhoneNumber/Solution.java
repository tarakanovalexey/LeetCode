package com.leetcode.LetterCombinationsOfAPhoneNumber;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        assertion(letterCombinations("23"), Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assertion(letterCombinations("2"), Arrays.asList("a", "b", "c"));
        assertion(letterCombinations(""), Collections.singletonList(""));
    }

    public static String mapper(String digit) {
        switch (digit) {
            case "2":
                return "abc";
            case "3":
                return "def";
            case "4":
                return "ghi";
            case "5":
                return "jkl";
            case "6":
                return "mno";
            case "7":
                return "pqrs";
            case "8":
                return "tuv";
            case "9":
                return "wxyz";
            default:
                return "";
        }
    }

    public static void recursiveSearch(List<String> digits, String leftOver, StringBuilder sb) {
        String letters = mapper(String.valueOf(leftOver.charAt(0)));
        leftOver = leftOver.replaceFirst(String.valueOf(leftOver.charAt(0)), "");
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            if (leftOver.length() > 0) {
                recursiveSearch(digits, leftOver, sb);
            } else {
                digits.add(sb.toString());
            }
            sb = sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        List<String> resultList = new ArrayList<>();
        recursiveSearch(resultList, digits, new StringBuilder());
        return resultList;
    }

    private static boolean assertion(List<String> result, List<String> expectedValue) {
        return new HashSet<>(expectedValue).containsAll(result) ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(List<String> result, List<String> expectedValue) {
        System.out.println("\u001B[31m" + "Failed: expected " + expectedValue.toString() + ", got " + result.toString());
        return true;
    }

    private static boolean printSuccess(List<String> result, List<String> expectedValue) {
        System.out.println("\u001B[32m" + "Success: expected " + expectedValue.toString() + ", got " + result.toString());
        return false;
    }
}
