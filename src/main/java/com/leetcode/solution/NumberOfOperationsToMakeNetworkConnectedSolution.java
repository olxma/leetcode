package com.leetcode.solution;

import com.leetcode.util.GraphUtil;

import java.util.List;
import java.util.Map;

/**
 * <b>Number of Operations to Make Network Connected</b>
 * <p>Level: <i>Medium</i></p>
 * <p>There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network
 * where connections[i] = [a<sub>i</sub>, b<sub>i</sub>]
 * represents a connection between computers a<sub>i</sub> and b<sub>i</sub>.
 * Any computer can reach any other computer directly or indirectly through the network.</p>
 *
 * <p>You are given an initial computer network connections.
 * You can extract certain cables between two directly connected computers,
 * and place them between any pair of disconnected computers to make them directly connected.</p>
 *
 * <p>Return the minimum number of times you need to do this in order to make all the computers connected.
 * If it is not possible, return -1.</p>
 *
 * @see <a href="link">1319. Number of Operations to Make Network Connected</a>
 */
public class NumberOfOperationsToMakeNetworkConnectedSolution {
    public int makeConnected(int n, int[][] connections) {
        int totalConnections = connections.length;
        if (totalConnections < n - 1) return -1; //check possibility to connect each computer to the whole network
        Map<Integer, List<Integer>> map = GraphUtil.getLinkedNodeMap(connections);

        boolean[] visited = new boolean[n];
        int totalSegments = 0;
        for (int i = 0; i < n; i++) {
            totalSegments += dfs(i, map, visited); //need to count separate network segments that need to be connected
        }
        return totalSegments - 1;
    }

    /**
     * Traverse the graph
     *
     * @param c       current computer
     * @param map     graph
     * @param visited flags
     * @return 1 if it is a separate segment starting from c, 0 if it's not
     */
    private static int dfs(int c, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[c]) return 0;
        visited[c] = true;
        List<Integer> neighbors = map.get(c);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                dfs(neighbor, map, visited);
            }
        }
        return 1;
    }
}
