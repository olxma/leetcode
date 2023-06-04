package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <b>Number of Provinces</b>
 * <p>Level: <i>Medium</i></p>
 * <p>There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c,
 * then city a is connected indirectly with city c.</p>
 *
 * <p>A province is a group of directly or indirectly connected cities and no other cities outside of the group.</p>
 *
 * <p>You are given an n x n matrix isConnected where isConnected[i][j] = 1
 * if the i<sup>th</sup> city and the j<sup>th</sup> city are directly connected,
 * and isConnected[i][j] = 0 otherwise.</p>
 *
 * <p>Return the total number of provinces.</p>
 *
 * @see <a href="https://leetcode.com/problems/number-of-provinces/">547. Number of Provinces</a>
 */
public class NumberOfProvincesSolution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> queue = new ArrayDeque<>();
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) continue;
            provinces++;
            queue.offer(i);

            while (!queue.isEmpty()) {
                Integer city = queue.poll();
                if (visited[city]) continue;
                visited[city] = true;
                for (int j = 0; j < isConnected[city].length; j++) {
                    if (isConnected[city][j] == 1) {
                        queue.offer(j);
                    }
                }
            }
        }
        return provinces;
    }
}
