package com.leetcode.LastStoneWeight;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    /*You are given an array of integers stones where stones[i] is the weight of the ith stone.

    We are playing a game with the stones. On each turn, we choose the heaviest two stones and
    smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

    If x == y, both stones are destroyed, and
    If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
    At the end of the game, there is at most one stone left.

    Return the weight of the last remaining stone. If there are no stones left, return 0.*/

    public static void main(String[] args) {
        assertion(lastStoneWeight(new int[]{2,7,4,1,8,1}), 1);
        assertion(lastStoneWeight(new int[]{1}), 1);
        assertion(lastStoneWeight(new int[]{1,3}), 2);
        assertion(lastStoneWeight(new int[]{10,4,2,10}), 2);
    }

    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = Arrays.stream(stones).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; list.size() > 1; ) {
            if (list.size() == 2) {
                return Math.max(list.get(0), list.get(1)) - Math.min(list.get(0), list.get(1));
            }
            if (Objects.equals(list.get(i), list.get(i + 1))) {
                list.remove(i);
                list.remove(i);
            } else if (list.get(i) > list.get(i+1)) {
                list.set(i, list.get(i) - list.get(i+1));
                list.remove(i+1);
            } else {
                list.set(i, list.get(i+1) - list.get(i));
                list.remove(i);
            }
            list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
        return list.isEmpty() ? 0 : list.get(0);
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
