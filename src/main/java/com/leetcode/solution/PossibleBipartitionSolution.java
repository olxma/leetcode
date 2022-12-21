package com.leetcode.solution;

import com.leetcode.util.GraphUtil;

import java.util.List;
import java.util.Map;

/**
 * <b>Possible Bipartition</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>We want to split a group of n people (labeled from 1 to n) into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.</p>
 *
 * <p>Given the integer n and the array dislikes where dislikes[i] = [a<sub>i</sub>, b<sub>i</sub>] indicates
 * that the person labeled a<sub>i</sub> does not like the person labeled b<sub>i</sub>,
 * return true if it is possible to split everyone into two groups in this way.</p>
 *
 * <p>Used: <a href="https://en.wikipedia.org/wiki/Bipartite_graph">Bipartite graph</a></p>
 *
 * @see <a href="https://leetcode.com/problems/possible-bipartition/description/">886. Possible Bipartition</a>
 *
 */
public class PossibleBipartitionSolution {
    private Map<Integer, List<Integer>> dislikeMap;
    private boolean[] visited;
    private int[] colors;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        dislikeMap = GraphUtil.getLinkedNodeMap(dislikes);

        visited = new boolean[n];
        colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (hasConflict(i, -1, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasConflict(int index, int parentIndex, int color) {
        visited[index] = true;
        colors[index] = color;

        if (parentIndex != -1) {
            if (color == colors[parentIndex]) {
                return true;
            }
        }

        List<Integer> persons = dislikeMap.get(index + 1);
        if (persons != null) {
            for (Integer person : persons) {
                if (!visited[person - 1]) {
                    if (hasConflict(person - 1, index, color * -1)) {
                        return true;
                    }
                } else if (colors[person - 1] == color) {
                    return true;
                }
            }
        }
        return false;
    }
}
