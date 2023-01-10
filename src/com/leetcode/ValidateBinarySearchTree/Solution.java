package com.leetcode.ValidateBinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.*/

    public static void main(String[] args) {
        assertion(isValidBST(new TreeNode(2, new TreeNode(2), new TreeNode(2))), false);
        assertion(isValidBST(new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)))), false);
        assertion(isValidBST(new TreeNode(0, null, new TreeNode(-1))), false);
        assertion(isValidBST(new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5, new TreeNode(4), new TreeNode(6)))), true);
        //[120,70,140,50,100,130,160,20,55,75,110,119,135,150,200] false
        assertion(isValidBST(new TreeNode(120,
                new TreeNode(70, new TreeNode(50, new TreeNode(20), new TreeNode(55)), new TreeNode(100, new TreeNode(75), new TreeNode(110))),
                new TreeNode(140, new TreeNode(130, new TreeNode(119), new TreeNode(135)), new TreeNode(160, new TreeNode(150), new TreeNode(200))))), false);
    }

    public static boolean isValidBST(TreeNode root) {
        return checkBST(root);
    }

    public static boolean checkBST(TreeNode node) {
        boolean result = true;
        if (node.right != null) {
            result = result && checkRightHand(node.right, null, node);
        }
        if (node.left != null) {
            result = result && checkLeftHand(node.left, node, null);
        }
        return result;
    }

    public static boolean checkRightHand(TreeNode node, TreeNode rightBorder, TreeNode leftBorder) {
        if (rightBorder != null && rightBorder.val <= node.val) {
            return false;
        }
        if (leftBorder != null && leftBorder.val >= node.val) {
            return false;
        }
        boolean result = true;
        if (node.left != null) {
            if (node.left.val >= node.val) {
                return false;
            }
            if (node.left.val < leftBorder.val) {
                return false;
            }
            result = result && checkLeftHand(node.left, node, leftBorder);
        }
        if (node.right != null) {
            if (node.right.val <= node.val) {
                return false;
            }
            result = result && checkRightHand(node.right, rightBorder, node);
        }
        return result;
    }

    public static boolean checkLeftHand(TreeNode node, TreeNode rightBorder, TreeNode leftBorder) {
        if (rightBorder != null && rightBorder.val <= node.val) {
            return false;
        }
        if (leftBorder != null && leftBorder.val >= node.val) {
            return false;
        }
        boolean result = true;
        if (node.left != null) {
            if (node.left.val >= node.val) {
                return false;
            }
            result = result && checkLeftHand(node.left, node, leftBorder);
        }
        if (node.right != null) {
            if (node.right.val <= node.val) {
                return false;
            }
            if (node.right.val > rightBorder.val) {
                return false;
            }
            result = result && checkRightHand(node.right, rightBorder, node);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
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
