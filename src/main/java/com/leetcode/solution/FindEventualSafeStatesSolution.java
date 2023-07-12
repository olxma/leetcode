package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Find Eventual Safe States</b>
 * <p>Level: <i>Medium</i></p>
 * <p>There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes
 * adjacent to node i, meaning there is an edge from node i to each node in graph[i].</p>
 *
 * <p>A node is a terminal node if there are no outgoing edges.
 * A node is a safe node if every possible path starting from
 * that node leads to a terminal node (or another safe node).</p>
 *
 * <p>Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.</p>
 *
 * @see <a href="https://leetcode.com/problems/find-eventual-safe-states/">802. Find Eventual Safe States</a>
 */
public class FindEventualSafeStatesSolution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] isSafeOrTerminal = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            explore(i, graph, isSafeOrTerminal);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < isSafeOrTerminal.length; i++) {
            if (isSafeOrTerminal[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }

    private static int explore(int node, int[][] graph, int[] isSafeOrTerminal) {
        if (isSafeOrTerminal[node] != 0) return isSafeOrTerminal[node];
        isSafeOrTerminal[node] = -1;

        if (graph[node].length == 0) {
            isSafeOrTerminal[node] = 1;
            return 1;
        }

        boolean isSafeNode = true;
        for (int neigbor : graph[node]) {
            isSafeNode &= explore(neigbor, graph, isSafeOrTerminal) == 1;
        }

        isSafeOrTerminal[node] = isSafeNode ? 1 : -1;
        return isSafeOrTerminal[node];
    }
}
