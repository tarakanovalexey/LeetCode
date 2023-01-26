package com.leetcode.NumberOfIslands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
     return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or
    vertically. You may assume all four edges of the grid are all surrounded by water.*/

    public static void main(String[] args) {
        assertion(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}), 1);
        assertion(numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}), 3);
        assertion(numIslands(new char[][]{{'1'},{'1'}}), 1);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int y = 0; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length; x++) {
                if (grid[x][y] == '1') {
                    grid[x][y] = '2';
                    searchUp(grid, x, y-1);
                    searchDown(grid, x, y+1);
                    searchRight(grid, x+1, y);
                    searchLeft(grid, x-1, y);
                    count++;
                }
            }
        }
        return count;
    }

    public static void searchUp(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            searchUp(grid, x, y-1);
            searchDown(grid, x, y+1);
            searchRight(grid, x+1, y);
            searchLeft(grid, x-1, y);
        }
    }

    public static void searchDown(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            searchUp(grid, x, y-1);
            searchDown(grid, x, y+1);
            searchRight(grid, x+1, y);
            searchLeft(grid, x-1, y);
        }
    }

    public static void searchRight(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            searchUp(grid, x, y-1);
            searchDown(grid, x, y+1);
            searchRight(grid, x+1, y);
            searchLeft(grid, x-1, y);
        }
    }

    public static void searchLeft(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            searchUp(grid, x, y-1);
            searchDown(grid, x, y+1);
            searchRight(grid, x+1, y);
            searchLeft(grid, x-1, y);
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
