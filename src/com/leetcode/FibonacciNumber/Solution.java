package com.leetcode.FibonacciNumber;

import java.util.ArrayList;

public class Solution {
    /*The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
    such that each number is the sum of the two preceding ones, starting from 0 and 1.
    That is,

    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.

    Given n, calculate F(n).*/

    public static void main(String[] args) {
        assertion(fib(0), 0);
        assertion(fib(1), 1);
        assertion(fib(2), 1);
        assertion(fib(3), 2);
        assertion(fib(4), 3);
        assertion(fib(5), 5);
        assertion(fib(6), 8);
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int prelast = 0;
        int last = 1;
        int mem = 0;
        for (int i = 2; i < n; i++) {
            mem = last;
            last = last + prelast;
            prelast = mem;
        }
        return prelast+last;
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
