package com.leetcode.solution;

import com.leetcode.util.GraphUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <b>Count Unreachable Pairs of Nodes in an Undirected Graph</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1.
 * You are given a 2D integer array edges where edges[i] = [a<sub>i</sub>, b<sub>i</sub>] denotes
 * that there exists an undirected edge connecting nodes a<sub>i</sub> and b<sub>i</sub>.</p>
 *
 * @see <a href="https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/">
 * 2316. Count Unreachable Pairs of Nodes in an Undirected Graph</a>
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraphSolution {
    public long countPairs(int n, int[][] edges) {
        long result = 0;
        if (edges.length == 0) {
            for(int i = n - 1; i > 0; i--) {
                result += i;
            }
            return result;
        }
        List<Long> segmentNodes = new ArrayList<>();
        Map<Integer, List<Integer>> graph = GraphUtil.getLinkedNodeMap(edges);

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            long s = bfs(i, graph, visited);
            if (s > 0) {
                segmentNodes.add(s);
            }
        }
        for (int i = 0; i < segmentNodes.size() - 1; i++) {
            long s1 = segmentNodes.get(i);
            for (int j = i + 1; j < segmentNodes.size(); j++) {
                long s2 = segmentNodes.get(j);
                result += s1 * s2;
            }
        }
        return result;
    }

    private static long bfs(int i, Map<Integer, List<Integer>> graph, boolean[] visited) {
        if (visited[i]) return 0;
        visited[i] = true;
        long result = 1;
        List<Integer> neighbors = graph.get(i);
        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                result += bfs(neighbor, graph, visited);
            }
        }
        return result;
    }
}
