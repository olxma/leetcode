package com.leetcode.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>Snakes and Ladders</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given an n x n integer matrix board
 * where the cells are labeled from 1 to n<sup>2</sup> in a Boustrophedon style
 * starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.</p>
 *
 * <p>You start on square 1 of the board. In each move, starting from square curr, do the following:</p>
 * <ul>
 *     <li>Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n<sup>2</sup>)].</li>
 *
 *     <li>This choice simulates the result of a standard 6-sided die roll: i.e.,
 *     there are always at most 6 destinations, regardless of the size of the board.</li>
 *
 *     <li>If next has a snake or ladder, you must move to the destination of that snake or ladder.
 *     Otherwise, you move to next.</li>
 *
 *     <li>The game ends when you reach the square n<sup>2</sup>.</li>
 * </ul>
 *
 * <p>A board square on row r and column c has a snake or ladder if board[r][c] != -1.
 * The destination of that snake or ladder is board[r][c].
 * Squares 1 and n<sup>2</sup> do not have a snake or ladder.</p>
 *
 * <p>Note that you only take a snake or ladder at most once per move.
 * If the destination to a snake or ladder is the start of another snake or ladder,
 * you do not follow the subsequent snake or ladder.</p>
 *
 * <ul><li>For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2.
 * You follow the ladder to square 3, but do not follow the subsequent ladder to 4.</li></ul>
 *
 * <p>Return the least number of moves required to reach the square n<sup>2</sup>.
 * If it is not possible to reach the square, return -1.</p>
 *
 * @see <a href="https://leetcode.com/problems/snakes-and-ladders/">909. Snakes and Ladders</a>
 */
public class SnakesAndLaddersSolution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                int row = cells[next].key();
                int column = cells[next].value();
                int destination = board[row][column] != -1 ? board[row][column] : next;
                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }
        return dist[n * n];
    }

    private record Pair(Integer key, Integer value) {
    }
}
