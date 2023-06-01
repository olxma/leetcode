package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <b>Shortest Path in Binary Matrix</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.</p>
 *
 * <p>A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:</p>
 *
 * <ul>
 *     <li>All the visited cells of the path are 0.</li>
 *     <li>All the adjacent cells of the path are 8-directionally connected
 *     (i.e., they are different and they share an edge or a corner).</li>
 * </ul>
 *
 * <p>The length of a clear path is the number of visited cells of this path.</p>
 *
 * @see <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/description/">
 * 1091. Shortest Path in Binary Matrix</a>
 */
public class ShortestPathInBinaryMatrixSolution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int result = 0;
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[n][m];
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();

                if (pos[0] == n - 1 && pos[1] == m - 1) {
                    return result;
                }

                for (int[] dir : dirs) {
                    int nextX = pos[0] + dir[0];
                    int nextY = pos[1] + dir[1];

                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m
                            || visited[nextX][nextY]
                            || grid[nextX][nextY] == 1) {
                        continue;
                    }
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }

        return -1;
    }
}
