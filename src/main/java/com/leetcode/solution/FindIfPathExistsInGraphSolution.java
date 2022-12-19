package com.leetcode.solution;

import java.util.*;

/**
 * <b>Find if Path Exists in Graph</b>
 * <p>Level: <i>Easy</i></p>
 * <p>There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges,
 * where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex u<sub>i</sub> and vertex <sub>vi</sub>.
 * Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.</p>
 *
 * <p>You want to determine if there is a valid path that exists from vertex source to vertex destination.</p>
 *
 * <p>Given edges and the integers n, source, and destination,
 * return true if there is a valid path from source to destination, or false otherwise.</p>
 *
 * @see <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/description/">1971. Find if Path Exists in Graph</a>
 */
public class FindIfPathExistsInGraphSolution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            if (current == destination) {
                return true;
            }

            for (int node : graph.get(current)) {
                if (!visited[node]) {
                    queue.offer(node);
                }
            }
        }
        return false;
    }
}
