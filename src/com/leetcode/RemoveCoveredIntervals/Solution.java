package com.leetcode.RemoveCoveredIntervals;

import java.util.HashSet;

public class Solution {
    /*Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri],
    remove all intervals that are covered by another interval in the list.

    The interval [a, b] is covered by the interval [c, d] if and only if c <= a and b <= d.

    Return the number of remaining intervals.*/

    public static void main(String[] args) {
        //assertion(removeCoveredIntervals(new int[][]{new int[]{1,4}, new int[]{3,6}, new int[]{2,8}}), 2);
        //assertion(removeCoveredIntervals(new int[][]{new int[]{1,4}, new int[]{2,3}}), 1);
        assertion(removeCoveredIntervals(new int[][]{new int[]{34335,39239}, new int[]{15875,91969}, new int[]{29673,66453}, new int[]{53548,69161}, new int[]{40618,93111}}), 2);
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        int a;
        int b;
        int c;
        int d;
        HashSet<Integer> removedPositions = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            if (removedPositions.contains(i)) {
                continue;
            }
            for (int y = 0; y < intervals.length; y++) {
                if (i == y) {
                    continue;
                }
                if (removedPositions.contains(y)) {
                    continue;
                }
                a = intervals[i][0];
                b = intervals[i][1];
                c = intervals[y][0];
                d = intervals[y][1];
                if (c <= a && b <= d) {
                    removedPositions.add(i);
                } else if (a < c && d < b) {
                    removedPositions.add(y);
                }
            }
        }
        return intervals.length - removedPositions.size();
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
