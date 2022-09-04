package com.leetcode.PlusOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of
    the integer. The digits are ordered from most significant to least significant in left-to-right order. The large
    integer does not contain any leading 0's.

    Increment the large integer by one and return the resulting array of digits.*/

    public static void main(String[] args) {
        assertion(plusOne(new int[]{1,2,3}), new int[]{1,2,4});
        assertion(plusOne(new int[]{9}), new int[]{1,0});
        assertion(plusOne(new int[]{3,2,9}), new int[]{3,3,0});
        assertion(plusOne(new int[]{9,9}), new int[]{1,0,0});
        assertion(plusOne(new int[]{8,9,9,9}), new int[]{9,0,0,0});
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        boolean addOneNext = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9 && addOneNext) {
                if (i == 0) {
                    result.add(0);
                    result.add(1);
                    break;
                }
                result.add(0);
            } else if (addOneNext) {
                result.add(digits[i] + 1);
                addOneNext = false;
            } else {
                result.add(digits[i]);
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean assertion(int[] result, int[] expectedValue) {
        return Arrays.equals(result, expectedValue) ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(int[] result, int[] expectedValue) {
        System.out.println("\u001B[31m"+"Failed: expected "+ Arrays.toString(expectedValue) +", got "+ Arrays.toString(result));
        return true;
    }

    private static boolean printSuccess(int[] result, int[] expectedValue) {
        System.out.println("\u001B[32m"+"Success: expected "+ Arrays.toString(expectedValue) +", got "+ Arrays.toString(result));
        return false;
    }
}
