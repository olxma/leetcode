package com.leetcode.solution;

import com.leetcode.util.GraphUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <b>Sum of Distances in Tree</b>
 * <p>Level: <i>Hard</i></p>
 *
 * <p>There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.</p>
 *
 * <p>You are given the integer n and the array edges where edges[i] = [a<sub>i</sub>, b<sub>i</sub>]
 * indicates that there is an edge between nodes a<sub>i</sub> and b<sub>i</sub> in the tree.</p>
 *
 * <p>Return an array answer of length n where answer[i] is the sum of the distances
 * between the i<sup>th</sup> node in the tree and all other nodes.</p>
 *
 * @see <a href="https://leetcode.com/problems/sum-of-distances-in-tree/">834. Sum of Distances in Tree</a>
 */
public class SumOfDistancesInTreeSolution {
    private Map<Integer, List<Integer>> linkedNodeMap;
    private int[] count;
    private int[] answer;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        linkedNodeMap = GraphUtil.getLinkedNodeMap(edges);
        answer = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);

        dfs1(0, -1);
        dfs2(0, -1);
        return answer;
    }

    private void dfs1(int node, int parent) {
        List<Integer> neighbors = linkedNodeMap.getOrDefault(node, List.of());
        for (int child : neighbors) {
            if (child != parent) {
                dfs1(child, node);
                count[node] += count[child];
                answer[node] += answer[child] + count[child];
            }
        }
    }

    public void dfs2(int node, int parent) {
        int n = linkedNodeMap.size();
        List<Integer> neighbors = linkedNodeMap.getOrDefault(node, List.of());
        for (int child : neighbors) {
            if (child != parent) {
                answer[child] = answer[node] - count[child] + n - count[child];
                dfs2(child, node);
            }
        }
    }
}
