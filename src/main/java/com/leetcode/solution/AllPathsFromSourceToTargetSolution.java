package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>All Paths From Source to Target</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
 * find all possible paths from node 0 to node n - 1 and return them in any order.</p>
 *
 * <p>The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
 * (i.e., there is a directed edge from node i to node graph[i][j]).</p>
 *
 * @see <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">
 * 797. All Paths From Source to Target</a>
 */
public class AllPathsFromSourceToTargetSolution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph.length == 0 || graph[0].length == 0) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, graph, res, list);

        return res;
    }

    public void dfs(int index, int[][] graph, List<List<Integer>> result, List<Integer> path) {
        if (index == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else {
            for (int n : graph[index]) {
                path.add(n);
                dfs(n, graph, result, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
