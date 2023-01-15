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
public class NumberOfGoodPathsSolutionOfficial {
    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++)
                parent[i] = i;
            rank = new int[size];
        }

        public int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        public void unionSet(int x, int y) {
            int xSet = find(x);
            int ySet = find(y);
            if (xSet == ySet) {
                return;
            }

            if (rank[xSet] < rank[ySet]) {
                parent[xSet] = ySet;
            } else if (rank[xSet] > rank[ySet]) {
                parent[ySet] = xSet;
            } else {
                parent[ySet] = xSet;
                rank[xSet]++;
            }
        }
    }

    // This is an official solution, my solution look at NumberOfGoodPathsSolution
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = GraphUtil.getLinkedNodeMap(edges);

        int n = vals.length;
        // Mapping from value to all the nodes having the same value in sorted order of
        // values.
        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<>()).add(i);
        }

        UnionFind dsu = new UnionFind(n);
        int goodPaths = 0;

        // Iterate over all the nodes with the same value in sorted order, starting from
        // the lowest value.
        for (Map.Entry<Integer, List<Integer>> entry : valuesToNodes.entrySet()) {
            // For every node in nodes, combine the sets of the node and its neighbors into
            // one set.
            for (int node : valuesToNodes.get(entry.getKey())) {
                if (!adj.containsKey(node))
                    continue;
                for (int neighbor : adj.get(node)) {
                    // Only choose neighbors with a smaller entry key value, as there is no point in
                    // traversing to other neighbors.
                    if (vals[node] >= vals[neighbor]) {
                        dsu.unionSet(node, neighbor);
                    }
                }
            }
            // Map to compute the number of nodes under observation (with the same values)
            // in each of the sets.
            Map<Integer, Integer> group = new HashMap<>();
            // Iterate over all the nodes. Get the set of each node and increase the count
            // of the set by 1.
            for (int u : valuesToNodes.get(entry.getKey())) {
                group.put(dsu.find(u), group.getOrDefault(dsu.find(u), 0) + 1);
            }
            // For each set of "size", add size * (size + 1) / 2 to the number of goodPaths.
            for (Map.Entry<Integer, Integer> groupEntry : group.entrySet()) {
                int size = groupEntry.getValue();
                goodPaths += size * (size + 1) / 2;
            }

        }
        return goodPaths;
    }
}
