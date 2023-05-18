package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Minimum Number of Vertices to Reach All Nodes</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a directed acyclic graph, with n vertices numbered from 0 to n-1,
 * and an array edges where edges[i] = [from<sub>i</sub>, to<sub>i</sub>] represents a directed edge
 * from node from<sub>i</sub> to node to<sub>i</sub>.</p>
 *
 * <p>Find the smallest set of vertices from which all nodes in the graph are reachable.
 * It's guaranteed that a unique solution exists.</p>
 *
 * <p>Notice that you can return the vertices in any order.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">
 * 1557. Minimum Number of Vertices to Reach All Nodes</a>
 */
public class MinimumNumberOfVerticesToReachAllNodesSolution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[n];
        for (List<Integer> edge : edges) {
            visited[edge.get(1)] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
