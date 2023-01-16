package com.leetcode.BullsAndCows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    /*You are playing the Bulls and Cows game with your friend.

    You write down a secret number and ask your friend to guess what the number is.
    When your friend makes a guess, you provide a hint with the following info:

    The number of "bulls", which are digits in the guess that are in the correct position.
    The number of "cows", which are digits in the guess that are in your secret number but are located
    in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged
    such that they become bulls.

    Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

    The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows.
    Note that both secret and guess may contain duplicate digits.*/

    public static void main(String[] args) {
        assertion(getHint("1807", "7810"), "1A3B");
        assertion(getHint("1123", "0111"), "1A1B");
        assertion(getHint("11", "10"), "1A0B");
    }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];
        ArrayList<Integer> skip = new ArrayList<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                skip.add(i);
            } else {
                nums[secret.charAt(i)-48] += 1;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (skip.contains(i)) {
                continue;
            }
            if (nums[guess.charAt(i)-48] > 0) {
                cows++;
                nums[guess.charAt(i)-48] -= 1;
            }
        }
        return bulls+"A"+cows+"B";
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
