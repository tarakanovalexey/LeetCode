package com.leetcode.FirstBadVersion;

import java.math.BigInteger;

public class Solution {
    /*You are a product manager and currently leading a team to develop a new product. Unfortunately,
    the latest version of your product fails the quality check. Since each version is developed based on the
    previous version, all the versions after a bad version are also bad.

    Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes
    all the following ones to be bad.

    You are given an API bool isBadVersion(version) which returns whether version is bad.
    Implement a function to find the first bad version. You should minimize the number of calls to the API.*/

    private static int wrongVersion = 1702766719;

    public static void main(String[] args) {
        assertion(firstBadVersion(2126753390), 1702766719);
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public static boolean isBadVersion(int version) {
        return version >= wrongVersion;
    }

    public static int firstBadVersion(int n) {
        if (n == 1) {
            return n;
        }
        BigInteger toCheck = BigInteger.valueOf(n/2+1);
        BigInteger lastSuccess = BigInteger.valueOf(0);
        BigInteger firstBad = BigInteger.valueOf(n);
        while (true) {
            if (isBadVersion(toCheck.intValue())) {
                firstBad = toCheck;
            } else {
                lastSuccess = toCheck;
            }
            toCheck = firstBad.add(lastSuccess).add(BigInteger.ONE).divide(BigInteger.valueOf(2));
            if (firstBad.subtract(lastSuccess).equals(BigInteger.ONE)) {
                return firstBad.intValue();
            }
        }
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
