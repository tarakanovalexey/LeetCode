package com.leetcode.CloneGraph;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*Given a reference of a node in a connected undirected graph.

    Return a deep copy (clone) of the graph.

    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.*/

    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        Node nodeClone = new Node();
        if (node.neighbors.isEmpty()) {
            return nodeClone;
        }
        for (int i = 0; i < node.neighbors.size(); i++) {

        }
        return node;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
