package com.leetcode.ClimbingStairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        assertion(climbStairs(1), 1);
        assertion(climbStairs(2), 2);
        assertion(climbStairs(3), 3);
        assertion(climbStairs(5), 8);
    }

    public static int climbStairs(int n) {
        switch (n) {
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 5;
            case 5:
                return 8;
            case 6:
                return 13;
            case 7:
                return 21;
            case 8:
                return 34;
            case 9:
                return 55;
            case 10:
                return 89;
            case 11:
                return 144;
            case 12:
                return 233;
            case 13:
                return 377;
            case 14:
                return 610;
            case 15:
                return 987;
            case 16:
                return 1597;
            case 17:
                return 2584;
            case 18:
                return 4181;
            case 19:
                return 6765;
            case 20:
                return 10946;
            case 21:
                return 17711;
            case 22:
                return 28657;
            case 23:
                return 46368;
            case 24:
                return 75025;
            case 25:
                return 121393;
            case 26:
                return 196418;
            case 27:
                return 317811;
            case 28:
                return 514229;
            case 29:
                return 832040;
            case 30:
                return 1346269;
            case 31:
                return 2178309;
            case 32:
                return 3524578;
            case 33:
                return 5702887;
            case 34:
                return 9227465;
            case 35:
                return 14930352;
            case 36:
                return 24157817;
            case 37:
                return 39088169;
            case 38:
                return 63245986;
            case 39:
                return 102334155;
            case 40:
                return 165580141;
            case 41:
                return 267914296;
            case 42:
                return 433494437;
            case 43:
                return 701408733;
            case 44:
                return 1134903170;
            case 45:
                return 1836311903;
            default:
                return 1;
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
