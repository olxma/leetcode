package com.leetcode.solution;

/**
 * <b>Unique Paths III</b>
 * <p>Level: <i>Hard</i></p>
 *
 * <p>You are given an m x n integer array grid where grid[i][j] could be:</p>
 * <ul>
 *     <li>1 representing the starting square. There is exactly one starting square.</li>
 *     <li>2 representing the ending square. There is exactly one ending square.</li>
 *     <li>0 representing empty squares we can walk over.</li>
 *     <li>-1 representing obstacles that we cannot walk over.</li>
 * </ul>
 *
 * <p>Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.</p>
 *
 * @see <a href="https://leetcode.com/problems/unique-paths-iii/">980. Unique Paths III</a>
 */
public class UniquePathsIIISolution {
    public int uniquePathsIII(int[][] grid) {
        int emptyCells = 0;
        int finishRow = 0;
        int finishColumn = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 0) {
                    emptyCells++;
                } else if (grid[row][column] == 1) {
                    finishRow = row;
                    finishColumn = column;
                }
            }
        }
        return path(grid, finishRow, finishColumn, emptyCells);
    }

    private static int path(int[][] grid, int x, int y, int cells) {
        if (isOutOrBlocked(grid, x, y)) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return cells == -1 ? 1 : 0;
        }
        grid[x][y] = -1;
        cells--;
        int totalCount = path(grid, x + 1, y, cells) +
                path(grid, x, y + 1, cells) +
                path(grid, x - 1, y, cells) +
                path(grid, x, y - 1, cells);
        grid[x][y] = 0;

        return totalCount;
    }

    private static boolean isOutOrBlocked(int[][] grid, int x, int y) {
        return x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1;
    }
}
