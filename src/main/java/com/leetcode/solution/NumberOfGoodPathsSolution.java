package com.leetcode.solution;

import com.leetcode.util.GraphUtil;

import java.util.*;

/**
 * <b>Number of Good Paths</b>
 * <p>Level: <i>Hard</i></p>
 * <p>There is a tree (i.e. a connected, undirected graph with no cycles)
 * consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.</p>
 *
 * <p>You are given a 0-indexed integer array vals of length n
 * where vals[i] denotes the value of the i<sup>th</sup> node.
 * You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes
 * that there exists an undirected edge connecting nodes a<sub>i</sub> and b<sub>i</sub>.</p>
 *
 * <p>A good path is a simple path that satisfies the following conditions:</p>
 *
 * <p>The starting node and the ending node have the same value.</p>
 *
 * <p>All nodes between the starting node and the ending node have values
 * less than or equal to the starting node
 * (i.e. the starting node's value should be the maximum value along the path).</p>
 *
 * <p>Return the number of distinct good paths.</p>
 *
 * <p>Note that a path and its reverse are counted as the same path.
 * For example, 0 -> 1 is considered to be the same as 1 -> 0.
 * A single node is also considered as a valid path.</p>
 *
 * @see <a href="https://leetcode.com/problems/number-of-good-paths/">2421. Number of Good Paths</a>
 */
public class NumberOfGoodPathsSolution {
    private int[] vals;
    private Map<Integer, List<Integer>> tree;
    private Set<Integer> startNodes;

    // This is my solution, it works, but a little slowly,
    // so LeetCode validator doesn't accept it due to Time Limit Exceeded.
    // I could not solve it in another way, look at an official solution: NumberOfGoodPathsSolutionOfficial
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        this.vals = vals;
        this.tree = GraphUtil.getLinkedNodeMap(edges);
        Map<Integer, List<Integer>> values = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            values.computeIfAbsent(vals[i], v -> new ArrayList<>()).add(i);
        }

        this.startNodes = new HashSet<>();
        int result = vals.length;
        for (Map.Entry<Integer, List<Integer>> entry : values.entrySet()) {
            if (entry.getValue().size() > 1) {
                for (Integer node : entry.getValue()) {
                    result += traverse(-1, node, node);
                    startNodes.add(node);
                }
            }
        }
        return result;
    }

    private int traverse(int parent, int startIndex, int node) {
        List<Integer> children = tree.get(node);
        int count = 0;
        for (Integer child : children) {
            if (child == parent) continue;
            if (vals[child] == vals[startIndex] && startNodes.contains(child)) {
                count++;
            }
            if (vals[child] <= vals[startIndex]) {
                count += traverse(node, startIndex, child);
            }
        }
        return count;
    }
}
