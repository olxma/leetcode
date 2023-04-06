package com.leetcode.solution;

/**
 * <b>Number of Closed Islands</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s
 * and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.</p>
 *
 * <p>Return the number of closed islands.</p>
 *
 * @see <a href="https://leetcode.com/problems/number-of-closed-islands/">1254. Number of Closed Islands</a>
 */
public class NumberOfClosedIslandsSolution {
    public int closedIsland(int[][] grid) {
        int x = grid[0].length;
        int y = grid.length;
        boolean[][] visited = new boolean[y][x];
        int result = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    result += checkIsland(i, j, grid, visited);
                }
            }
        }
        return result;
    }

    private static int checkIsland(int i, int j, int[][] grid, boolean[][] visited) {
        if (i >= grid.length - 1 || i <= 0 || j >= grid[i].length - 1 || j <= 0) return 0;
        if (visited[i][j]) return 1;

        visited[i][j] = true;
        int up = 1;
        int down = 1;
        int left = 1;
        int right = 1;
        if (grid[i - 1][j] == 0) {
            up = checkIsland(i - 1, j, grid, visited);
        }
        if (grid[i + 1][j] == 0) {
            down = checkIsland(i + 1, j, grid, visited);
        }
        if (grid[i][j - 1] == 0) {
            left = checkIsland(i, j - 1, grid, visited);
        }
        if (grid[i][j + 1] == 0) {
            right = checkIsland(i, j + 1, grid, visited);
        }
        return up * down * left * right;
    }
}
