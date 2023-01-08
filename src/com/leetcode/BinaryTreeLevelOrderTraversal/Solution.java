package com.leetcode.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*Given the root of a binary tree, return the level order traversal of its nodes' values.
     (i.e., from left to right, level by level).*/

    public static void main(String[] args) {
        //assertion(levelOrder(new TreeNode(1)), Arrays.asList(1,2,3));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        int level = -1;
        List<List<Integer>> list = new ArrayList<>();
        addVals(root, list, level);
        return list;
    }

    static public void addVals(TreeNode node, List<List<Integer>> list, int level) {
        level += 1;
        if (list.size() < level + 1) {
            list.add(new ArrayList<>());
        }
        if (node != null) {
            list.get(level).add(node.val);
            if (node.left != null) {
                addVals(node.left, list, level);
            }
            if (node.right != null) {
                addVals(node.right, list, level);
            }
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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
