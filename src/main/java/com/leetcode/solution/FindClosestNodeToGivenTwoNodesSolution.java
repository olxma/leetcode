package com.leetcode.solution;

/**
 * <b>Find Closest Node to Given Two Nodes</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a directed graph of n nodes numbered from 0 to n - 1,
 * where each node has at most one outgoing edge.</p>
 *
 * <p>The graph is represented with a given 0-indexed array edges of size n,
 * indicating that there is a directed edge from node i to node edges[i].
 * If there is no outgoing edge from i, then edges[i] == -1.</p>
 *
 * <p>You are also given two integers node1 and node2.</p>
 *
 * <p>Return the index of the node that can be reached from both node1 and node2,
 * such that the maximum between the distance from node1 to that node, and from node2 to that node is minimized.
 * If there are multiple answers, return the node with the smallest index,
 * and if no possible answer exists, return -1.</p>
 *
 * <p>Note that edges may contain cycles.</p>
 *
 * @see <a href="https://leetcode.com/problems/find-closest-node-to-given-two-nodes/">
 * 2359. Find Closest Node to Given Two Nodes</a>
 */
public class FindClosestNodeToGivenTwoNodesSolution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        dfs(node1, edges, dist1, visited1);
        dfs(node2, edges, dist2, visited2);

        int result = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (visited1[i] && visited2[i] && min > Math.max(dist1[i], dist2[i])) {
                min = Math.max(dist1[i], dist2[i]);
                result = i;
            }
        }
        return result;
    }

    public void dfs(int node, int[] edges, int[] distance, boolean[] visited) {
        visited[node] = true;
        int next = edges[node];
        if (next != -1 && !visited[next]) {
            distance[next] = distance[node] + 1;
            dfs(next, edges, distance, visited);
        }
    }
}
