package com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>Reorder Routes to Make All Paths Lead to the City Zero</b>
 * <p>Level: <i>Medium</i></p>
 * <p>There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel
 * between two different cities (this network form a tree).
 * Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.</p>
 *
 * <p>Roads are represented by connections where connections[i] = [a<sub>i</sub>, b<sub>i</sub>] represents a road
 * from city a<sub>i</sub> to city b<sub>i</sub>.</p>
 *
 * <p>This year, there will be a big event in the capital (city 0), and many people want to travel to this city.</p>
 *
 * <p>Your task consists of reorienting some roads such that each city can visit the city 0.
 * Return the minimum number of edges changed.</p>
 *
 * <p>It's guaranteed that each city can reach city 0 after reorder.</p>
 *
 * @see <a href="link">1466. Reorder Routes to Make All Paths Lead to the City Zero</a>
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZeroSolution {
    private int changes = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            graph.computeIfAbsent(a, val -> new ArrayList<>()).add(connection);
            graph.computeIfAbsent(b, val -> new ArrayList<>()).add(connection);
        }

        boolean[] visited = new boolean[n];
        dfs(0, graph, visited);
        return changes;
    }

    private void dfs(int c, Map<Integer, List<int[]>> graph, boolean[] visited) {
        if (visited[c]) return;
        visited[c] = true;
        List<int[]> connections = graph.get(c);
        for (int[] connection : connections) {
            int destination = connection[0] == c ? connection[1] : connection[0];
            if (!visited[destination]) {
                this.changes += connection[0] == c ? 1 : 0;
                dfs(destination, graph, visited);
            }
        }
    }
}
