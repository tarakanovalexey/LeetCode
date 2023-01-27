package com.leetcode.FloodFill;

public class Solution {
    /*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
     return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or
    vertically. You may assume all four edges of the grid are all surrounded by water.*/

    public static void main(String[] args) {
        assertion(floodFill(new int[][]{{'1','1','1'},{'1','1','0'},{'1','0','1'}}, 1, 1, 2),
                new int[][]{{'2','2','2'},{'2','2','0'},{'2','0','1'}});
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int colorToChange = image[sr][sc];
        if (colorToChange != color) {
            image[sr][sc] = color;
            searchUp(image, sr, sc - 1, color, colorToChange);
            searchDown(image, sr, sc + 1, color, colorToChange);
            searchRight(image, sr + 1, sc, color, colorToChange);
            searchLeft(image, sr - 1, sc, color, colorToChange);
        }
        return image;
    }

    public static void searchUp(int[][] grid, int x, int y, int color, int colorToChange) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == colorToChange) {
            grid[x][y] = color;
            searchUp(grid, x, y-1, color, colorToChange);
            searchDown(grid, x, y+1, color, colorToChange);
            searchRight(grid, x+1, y, color, colorToChange);
            searchLeft(grid, x-1, y, color, colorToChange);
        }
    }

    public static void searchDown(int[][] grid, int x, int y, int color, int colorToChange) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == colorToChange) {
            grid[x][y] = color;
            searchUp(grid, x, y-1, color, colorToChange);
            searchDown(grid, x, y+1, color, colorToChange);
            searchRight(grid, x+1, y, color, colorToChange);
            searchLeft(grid, x-1, y, color, colorToChange);
        }
    }

    public static void searchRight(int[][] grid, int x, int y, int color, int colorToChange) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == colorToChange) {
            grid[x][y] = color;
            searchUp(grid, x, y-1, color, colorToChange);
            searchDown(grid, x, y+1, color, colorToChange);
            searchRight(grid, x+1, y, color, colorToChange);
            searchLeft(grid, x-1, y, color, colorToChange);
        }
    }

    public static void searchLeft(int[][] grid, int x, int y, int color, int colorToChange) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == colorToChange) {
            grid[x][y] = color;
            searchUp(grid, x, y-1, color, colorToChange);
            searchDown(grid, x, y+1, color, colorToChange);
            searchRight(grid, x+1, y, color, colorToChange);
            searchLeft(grid, x-1, y, color, colorToChange);
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
