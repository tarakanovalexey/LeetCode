package com.leetcode.ReverseString;

import java.util.Arrays;

public class Solution {

    /*Write a function that reverses a string. The input string is given as an array of characters s.

    You must do this by modifying the input array in-place with O(1) extra memory.*/

    public static void main(String[] args) {
        char[] c = new char[]{'h','e','l','l','o'};
        reverseString(c);
        assertion(c, new char[]{'o','l','l','e','h'});
        c = new char[]{'H','a','n','n','a','h'};
        reverseString(c);
        assertion(c, new char[]{'h','a','n','n','a','H'});
    }

    public static void reverseString(char[] s) {
        char z;
        for (int i = 0; i < s.length/2; i++) {
            z = s[i];
            s[i] = s[s.length-1 - i];
            s[s.length-1 - i] = z;
        }
    }

    private static boolean assertion(char[] result, char[] expectedValue) {
        return Arrays.equals(result, expectedValue) ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(char[] result, char[] expectedValue) {
        System.out.println("\u001B[31m"+"Failed: expected "+ Arrays.toString(expectedValue) +", got "+ Arrays.toString(result));
        return true;
    }

    private static boolean printSuccess(char[] result, char[] expectedValue) {
        System.out.println("\u001B[32m"+"Success: expected "+ Arrays.toString(expectedValue) +", got "+ Arrays.toString(result));
        return false;
    }
}
