package com.leetcode.IntegerToRoman;

public class Solution {

    public static void main(String[] args) {
        assertion(intToRoman(58), "LVIII");
        assertion(intToRoman(1994), "MCMXCIV");
        assertion(intToRoman(3), "III");
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String sNum = String.valueOf(num);
        int mod = (int) Math.pow(10, String.valueOf(num).length() - 1);
        int currentKey;
        for (int i = 0; i < sNum.length(); i++) {
            currentKey = sNum.charAt(i) - 48;
            if (currentKey < 4) {
                for (int j = 0; j < currentKey; j++) {
                    sb.append(RomanNum.getByValue(mod));
                }
            } else if (currentKey > 5 && currentKey < 9) {
                sb.append(RomanNum.getByValue(5 * mod));
                for (int j = 0; j < currentKey - 5; j++) {
                    sb.append(RomanNum.getByValue(mod));
                }
            } else {
                sb.append(RomanNum.getByValue(currentKey * mod));
            }
            mod = mod / 10;
        }
        return sb.toString();
    }

    public enum RomanNum {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);

        private int value;

        RomanNum(int value) {
            this.value = value;
        }

        public static RomanNum getByValue(int text) {
            for (RomanNum num : RomanNum.values()) {
                if (num.value == text) {
                    return num;
                }
            }
            return null;
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
