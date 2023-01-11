package com.leetcode.LowestCommonAncestorOfABinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p
    and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant
    of itself).”*/

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(4);
        t2.left = t4;
        t2.right = t5;
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(9);
        t3.left = t6;
        t3.right = t7;
        TreeNode t8 = new TreeNode(3);
        TreeNode t9 = new TreeNode(5);
        t5.left = t8;
        t5.right = t9;
        assertion(lowestCommonAncestor(t1, t2, t3), t1);
        //[5,3,6,2,4,null,null,1] 3
        TreeNode z1 = new TreeNode(5);
        TreeNode z2 = new TreeNode(3);
        TreeNode z3 = new TreeNode(6);
        z1.left = z2;
        z1.right = z3;
        TreeNode z4 = new TreeNode(2);
        TreeNode z5 = new TreeNode(4);
        z2.left = z4;
        z2.right = z5;
        TreeNode z6 = new TreeNode(1);
        z4.left = z6;
        assertion(lowestCommonAncestor(z1, z6, z5), z2);
        //[6,2,8,0,4,7,9,null,null,3,5] 4
        TreeNode x1 = new TreeNode(6);
        TreeNode x2 = new TreeNode(2);
        TreeNode x3 = new TreeNode(8);
        x1.left = x2;
        x1.right = x3;
        TreeNode x4 = new TreeNode(0);
        TreeNode x5 = new TreeNode(4);
        x2.left = x4;
        x2.right = x5;
        TreeNode x6 = new TreeNode(7);
        TreeNode x7 = new TreeNode(9);
        x3.left = x6;
        x3.right = x7;
        TreeNode x8 = new TreeNode(3);
        TreeNode x9 = new TreeNode(5);
        x5.left = x8;
        x5.right = x9;
        assertion(lowestCommonAncestor(x1, x8, x9), x5);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ancestors1 = new ArrayList<>();
        getAncestor(root, p, ancestors1);
        List<TreeNode> ancestors2 = new ArrayList<>();
        getAncestor(root, q, ancestors2);
        Collections.reverse(ancestors1);
        Collections.reverse(ancestors2);
        for (TreeNode t1 : ancestors1) {
            for (TreeNode t2 : ancestors2) {
                if (t1.val == t2.val) {
                    return t1;
                }
            }
        }
        return root;
    }

    public static void getAncestor(TreeNode root, TreeNode node, List<TreeNode> ancestorList) {
        ancestorList.add(root);
        if (root.right != null && node.val > root.val) {
            getAncestor(root.right, node, ancestorList);
        } else if (root.left != null && node.val < root.val) {
            getAncestor(root.left, node, ancestorList);
        }
    }

    public static class TreeNode {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TreeNode treeNode = (TreeNode) o;

            return val == treeNode.val;
        }

        @Override
        public int hashCode() {
            return val;
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
