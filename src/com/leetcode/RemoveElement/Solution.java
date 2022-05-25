package com.leetcode.RemoveElement;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    The relative order of the elements may be changed.

    Since it is impossible to change the length of the array in some languages, you must instead have the result
    be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
    then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first
    k elements.

    Return k after placing the final result in the first k slots of nums.

    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1)
    extra memory.*/

    public static void main(String[] args) {
        assertion(removeElement(new int[]{2,3,7,8,8,9,9}, 1), 7);
        assertion(removeElement(new int[]{}, 0), 0);
        assertion(removeElement(new int[]{2,3,7,8,8,9,9}, 9), 5);
        assertion(removeElement(new int[]{2,3,7,8,8,9,9}, 3), 6);
    }

    public static int removeElement(int[] nums, int val) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    private static boolean assertion(int result, int expectedValue) {
        return result == expectedValue ? printSuccess(result, expectedValue) : printFailed(result, expectedValue);
    }

    private static boolean printFailed(int result, int expectedValue) {
        System.out.println("\u001B[31m"+"Failed: expected "+expectedValue+", got "+result);
        return true;
    }

    private static boolean printSuccess(int result, int expectedValue) {
        System.out.println("\u001B[32m"+"Success: expected "+expectedValue+", got "+result);
        return false;
    }
}
