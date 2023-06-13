package com.leetcode.solution;

import java.util.*;

/**
 * <b>Equal Row and Column Pairs</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a 0-indexed n x n integer matrix grid,
 * return the number of pairs (r<sub>i</sub>, c<sub>j</sub>)
 * such that row r<sub>i</sub> and column c<sub>j</sub> are equal.</p>
 *
 * <p>A row and column pair is considered equal
 * if they contain the same elements in the same order (i.e., an equal array).</p>
 *
 * @see <a href="https://leetcode.com/problems/equal-row-and-column-pairs/">2352. Equal Row and Column Pairs</a>
 */
public class EqualRowAndColumnPairsSolution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> rows = new HashMap<>();
        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>(row.length);
            for (int i : row) {
                rowList.add(i);
            }
            rows.compute(rowList, (k, v) -> v == null ? 1 : v + 1);
        }

        int result = 0;
        for (int i = 0; i < grid[0].length; i++) {
            List<Integer> columnList = new ArrayList<>(grid[0].length);
            for (int[] row : grid) {
                columnList.add(row[i]);
            }
            int pairs = rows.getOrDefault(columnList, 0);
            result += pairs;
        }

        return result;
    }
}
