package com.leetcode.solution;

import java.util.*;

/**
 * <b>Is Graph Bipartite?</b>
 * <p>Level: <i>Medium</i></p>
 * <p>There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
 * More formally, for each v in graph[u], there is an undirected edge between node u and node v.
 * The graph has the following properties:</p>
 *
 * <ul>
 *     <li>There are no self-edges (graph[u] does not contain u).</li>
 *     <li>There are no parallel edges (graph[u] does not contain duplicate values).</li>
 *     <li>If v is in graph[u], then u is in graph[v] (the graph is undirected).</li>
 *     <li>The graph may not be connected,
 *     meaning there may be two nodes u and v such that there is no path between them.</li>
 * </ul>
 *
 * <p>A graph is bipartite if the nodes can be partitioned into two independent sets A and B
 * such that every edge in the graph connects a node in set A and a node in set B.</p>
 *
 * <p>Return true if and only if it is bipartite.</p>
 *
 * @see <a href="https://leetcode.com/problems/is-graph-bipartite/description/">785. Is Graph Bipartite?</a>
 */
public class IsGraphBipartiteSolution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int node = 0; node < n; node++) {
            if (color[node] != 0) {
                continue;
            }
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(node);
            color[node] = 1;
            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                for (int nextNode : graph[currentNode]) {
                    if (color[nextNode] == 0) {
                        color[nextNode] = -color[currentNode];
                        queue.add(nextNode);
                    } else if (color[nextNode] != -color[currentNode]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
