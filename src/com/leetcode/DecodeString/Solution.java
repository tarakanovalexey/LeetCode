package com.leetcode.DecodeString;

public class Solution {
    /*Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being
    repeated exactly k times. Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; there are no extra white spaces, square brackets are
    well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that
    digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

    The test cases are generated so that the length of the output will never exceed 105.*/

    public static void main(String[] args) {
        assertion(decodeString("3[a]2[bc]"), "aaabcbc");
        assertion(decodeString("3[a2[c]]"), "accaccacc");
        assertion(decodeString("2[abc]3[cd]ef"), "abcabccdcdcdef");
        assertion(decodeString("2[ab3[cd]]4[xy]"), "abcdcdcdabcdcdcdxyxyxyxy");
    }

    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder mult = new StringBuilder();
        int multi = 0;
        StringBuilder seq = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                mult.append(s.charAt(i));
            } else if (s.charAt(i) == 91) {
                counter++;
                if (counter == 1) {
                    multi = Integer.parseInt(mult.toString());
                    StringBuilder underseq = new StringBuilder();
                    int c = 0;
                    for (int o = i+1; o < s.length(); o++) {
                        if (s.charAt(o) == 91) {
                            underseq.append(s.charAt(o));
                            c++;
                        } else if (s.charAt(o) == 93 && c == 0) {
                            break;
                        } else if (s.charAt(o) == 93) {
                            underseq.append(s.charAt(o));
                            c--;
                        } else {
                            underseq.append(s.charAt(o));
                        }
                    }
                    for (int j = 0; j < multi; j++) {
                        result.append(decodeString(underseq.toString()));
                    }
                    mult = new StringBuilder();
                    seq = new StringBuilder();
                }
            } else if (s.charAt(i) == 93) {
                counter--;
                if (counter == 0) {
                    mult = new StringBuilder();
                    seq = new StringBuilder();
                }
            } else if (counter == 0) {
                result.append(s.charAt(i));
            } else {
                seq.append(s.charAt(i));
            }
        }
        return result.toString();
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
