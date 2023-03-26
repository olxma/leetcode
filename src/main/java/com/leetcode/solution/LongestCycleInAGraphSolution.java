package com.leetcode.solution;

/**
 * <b>Longest Cycle in a Graph</b>
 * <p>Level: <i>Hard</i></p>
 * <p>You are given a directed graph of n nodes numbered from 0 to n - 1,
 * where each node has at most one outgoing edge.</p>
 *
 * <p>The graph is represented with a given 0-indexed array edges of size n,
 * indicating that there is a directed edge from node i to node edges[i].
 * If there is no outgoing edge from node i, then edges[i] == -1.</p>
 *
 * <p>Return the length of the longest cycle in the graph. If no cycle exists, return -1.</p>
 *
 * <p>A cycle is a path that starts and ends at the same node.</p>
 *
 * @see <a href="link">2360. Longest Cycle in a Graph</a>
 */
public class LongestCycleInAGraphSolution {
    public int longestCycle(int[] edges) {
        int max = -1;
        int counter = 1;
        int[] visited = new int[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (visited[i] > 0) continue;
            int start = counter;
            int node = i;
            while (node != -1 && visited[node] == 0) {
                visited[node] = counter++;
                node = edges[node];
            }
            if (node != -1 && visited[node] >= start) {
                max = Math.max(max, counter - visited[node]);
            }
        }

        return max;
    }
}
