package com.leetcode.NaryTreePreorderTraversal;

import java.util.*;

public class Solution {
    /*Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal.
    Each group of children is separated by the null value (See examples)*/

    public static void main(String[] args) {
        //assertion(preorder(new Node(1)), Arrays.asList(1,2,3));
    }

    public static List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            addRecursive(list, root);
        }
        return list;
    }

    public static void addRecursive(ArrayList<Integer> list, Node node) {
        list.add(node.val);
        if (node.children != null) {
            for (Node n : node.children) {
                addRecursive(list, n);
            }
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

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
