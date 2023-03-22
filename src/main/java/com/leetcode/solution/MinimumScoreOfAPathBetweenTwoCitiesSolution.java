package com.leetcode.solution;

import com.leetcode.util.GraphUtil;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <b>Minimum Score of a Path Between Two Cities</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a positive integer n representing n cities numbered from 1 to n.
 * You are also given a 2D array roads where roads[i] = [a<sub>i</sub>, b<sub>i</sub>, distance<sub>i</sub>] indicates
 * that there is a bidirectional road between cities a<sub>i</sub> and b<sub>i</sub>
 * with a distance equal to distance<sub>i</sub>. The cities graph is not necessarily connected.</p>
 *
 * <p>The score of a path between two cities is defined as the minimum distance of a road in this path.</p>
 *
 * <p>Return the minimum possible score of a path between cities 1 and n.</p>
 * <p>Note:</p>
 * <ul>
 *     <li>A path is a sequence of roads between two cities.</li>
 *     <li>It is allowed for a path to contain the same road multiple times,
 *     and you can visit cities 1 and n multiple times along the path.</li>
 *     <li>The test cases are generated such that there is at least one path between 1 and n.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/">2492. Minimum Score of a Path Between Two Cities</a>
 */
public class MinimumScoreOfAPathBetweenTwoCitiesSolution {

    public int minScore(int n, int[][] roads) {
        int min = Integer.MAX_VALUE;
        Map<Integer, List<GraphUtil.Direction>> graph = GraphUtil.getLinkedNodeMapWithLength(roads);
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.add(1);
        while (!queue.isEmpty()) {
            int city = queue.poll();
            visited[city - 1] = true;
            List<GraphUtil.Direction> directions = graph.get(city);
            for (GraphUtil.Direction direction : directions) {
                if (!visited[direction.to() - 1]) {
                    min = Math.min(min, direction.length());
                    queue.add(direction.to());
                }
            }
        }
        return min;
    }
}
