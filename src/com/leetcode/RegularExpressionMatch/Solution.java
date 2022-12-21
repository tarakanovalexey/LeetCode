package com.leetcode.RegularExpressionMatch;

public class Solution {

    public static void main(String[] args) {
        /*assertion(isMatch("aa", "a"), false);
        assertion(isMatch("aa", "a*"), true);
        assertion(isMatch("ab", ".*"), true);
        assertion(isMatch("", ".*"), true);
        assertion(isMatch("", ""), true);
        assertion(isMatch(" ", " "), true);
        assertion(isMatch("acacbz", "a.a.b."), true);
        assertion(isMatch("acabbbbaaa", "acab*a*"), true);
        assertion(isMatch("acazzz", "acab*z*"), true);
        assertion(isMatch("aca", "acab*z*"), true);
        assertion(isMatch("mississippi", "mis*is*p*."), false);
        assertion(isMatch("ab", ".*c"), false);
        assertion(isMatch("aaa", "aaaa"), false);*/
        assertion(isMatch("a", "ab*a"), false);
    }

    public static boolean isMatch(String s, String p) {
        if (s.equals(p) || (p.equals(".*"))) {
            return true;
        } else if (p.split("\\.\\*").length > 1) {
            return false;
        } else if (!p.contains("*") && s.length() != p.length()) {
            return false;
        }
        int j = 0;
        Pair pair = new Pair();
        try {
            for (int i = 0; i < s.toCharArray().length; i++) {
                if (pair.isPresent()) {
                    if (i + 1 >= s.toCharArray().length) {
                        pair.setPresent(false);
                    }
                    if (pair.getValue() == '.' || pair.getValue() == s.charAt(i)) {
                        continue;
                    }
                    if (pair.getValue() != s.charAt(i)) {
                        pair.setPresent(false);
                        j++;
                    }
                }
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    pair.setPresent(true);
                    pair.setValue(p.charAt(j));
                    j++;
                    i--;
                } else if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    j++;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static class Pair {
        boolean present;
        char value;

        public Pair() {
        }

        public Pair(boolean present, char value) {
            this.present = present;
            this.value = value;
        }

        public void setPresent(boolean present) {
            this.present = present;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public boolean isPresent() {
            return present;
        }

        public char getValue() {
            return value;
        }
    }

    private static boolean assertion(boolean result, boolean expectedValue) {
        return result == expectedValue ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(boolean result, boolean expectedValue) {
        System.out.println("\u001B[31m"+"Failed: expected "+ expectedValue +", got "+ result);
        return true;
    }

    private static boolean printSuccess(boolean result, boolean expectedValue) {
        System.out.println("\u001B[32m"+"Success: expected "+ expectedValue +", got "+ result);
        return false;
    }
}
