package com.leetcode.solution;

import com.leetcode.util.GraphUtil;

import java.util.List;
import java.util.Map;

/**
 * <b>Minimum Time to Collect All Apples in a Tree</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given an undirected tree consisting of n vertices numbered from 0 to n-1,
 * which has some apples in their vertices. You spend 1 second to walk over one edge of the tree.
 * Return the minimum time in seconds you have to spend to collect all apples in the tree,
 * starting at vertex 0 and coming back to this vertex.</p>
 *
 * <p>The edges of the undirected tree are given in the array edges,
 * where edges[i] = [a<sub>i</sub>, b<sub>i</sub>] means
 * that exists an edge connecting the vertices a<sub>i</sub> and b<sub>i</sub>.
 * Additionally, there is a boolean array hasApple, where hasApple[i] = true means
 * that vertex i has an apple; otherwise, it does not have any apple.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/">
 *     1443. Minimum Time to Collect All Apples in a Tree</a>
 */
public class MinimumTimeToCollectAllApplesInATreeSolution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> tree = GraphUtil.getLinkedNodeMap(edges);
        return traverse(-1, 0, tree, hasApple);
    }

    private int traverse(int parent, int node, Map<Integer, List<Integer>> tree, List<Boolean> hasApple) {
        int time = 0;
        if (tree.get(node) != null) {
            for (int child : tree.get(node)) {
                if (child == parent) continue;
                time += traverse(node, child, tree, hasApple);
            }
        }
        return time + (node != 0 && (time > 0 || hasApple.get(node)) ? 2 : 0);
    }
}
