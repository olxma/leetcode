package com.leetcode.solution;

import com.leetcode.util.GraphUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>Number of Nodes in the Sub-Tree With the Same Label</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes
 * numbered from 0 to n - 1 and exactly n - 1 edges.
 * The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character
 * given in the string labels (i.e. The node with the number i has the label labels[i]).</p>
 *
 * <p>The edges array is given on the form edges[i] = [a<sub>i</sub>, b<sub>i</sub>],
 * which means there is an edge between nodes a<sub>i</sub> and b<sub>i</sub> in the tree.</p>
 *
 * <p>Return an array of size n where ans[i] is the number of nodes in the subtree of the i<sup>th</sup> node
 * which have the same label as node i.</p>
 *
 * <p>A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.</p>
 *
 * @see <a href="https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/">
 * 1519. Number of Nodes in the Sub-Tree With the Same Label</a>
 */
public class NumberOfNodesInTheSubTreeWithTheSameLabelSolution {
    private Map<Integer, Map<Character, Integer>> map;
    private Map<Integer, List<Integer>> tree;
    private String labels;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.map = new HashMap<>();
        this.tree = GraphUtil.getLinkedNodeMap(edges);
        this.labels = labels;

        traverse(-1, 0);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = map.get(i).get(labels.charAt(i));
        }
        return answer;
    }

    private void traverse(int parent, int node) {
        char c = labels.charAt(node);
        Map<Character, Integer> nodeMap = new HashMap<>();
        nodeMap.put(c, 1);
        map.put(node, nodeMap);
        if (tree.get(node) != null) {
            for (int child : tree.get(node)) {
                if (child == parent) continue;
                traverse(node, child);
                Map<Character, Integer> childMap = map.get(child);
                for (Map.Entry<Character, Integer> entry : childMap.entrySet()) {
                    nodeMap.compute(entry.getKey(), (k, v) -> v == null ? entry.getValue() : v + entry.getValue());
                }
            }
        }
    }
}
