package com.leetcode.IsomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving
    the order of characters. No two characters may map to the same character, but a character may map to itself.*/

    public static void main(String[] args) {
        assertion(isIsomorphic("egg", "add"), true);
        assertion(isIsomorphic("foo", "bar"), false);
        assertion(isIsomorphic("paper", "title"), true);
        assertion(isIsomorphic("badc", "baba"), false);
        assertion(isIsomorphic("ab", "ca"), true);
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            } else if (set.contains(t.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
        //Better solution, but not mine
        /*for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(s.lastIndexOf(c1) != t.lastIndexOf(c2))
                return false;
        }
        return true;*/
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
