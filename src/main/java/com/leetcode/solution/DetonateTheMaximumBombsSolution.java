package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <b>Detonate the Maximum Bombs</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt.
 * This area is in the shape of a circle with the center as the location of the bomb.</p>
 *
 * <p>The bombs are represented by a 0-indexed 2D integer array bombs
 * where bombs[i] = [x<sub>i</sub>, y<sub>i</sub>, r<sub>i</sub>].
 * x<sub>i</sub> and y<sub>i</sub> denote the X-coordinate and Y-coordinate of the location of the ith bomb,
 * whereas r<sub>i</sub> denotes the radius of its range.</p>
 *
 * <p>You may choose to detonate a single bomb. When a bomb is detonated,
 * it will detonate all bombs that lie in its range.
 * These bombs will further detonate the bombs that lie in their ranges.</p>
 *
 * <p>Given the list of bombs, return the maximum number of bombs that can be detonated
 * if you are allowed to detonate only one bomb.</p>
 *
 * @see <a href="https://leetcode.com/problems/detonate-the-maximum-bombs/">2101. Detonate the Maximum Bombs</a>
 */
public class DetonateTheMaximumBombsSolution {
    public int maximumDetonation(int[][] bombs) {
        int result = 1;

        if (bombs.length == 1) return 1;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < bombs.length; i++) {
            boolean[] visited = new boolean[bombs.length];
            visited[i] = true;
            int count = 0;
            queue.add(bombs[i]);

            while (!queue.isEmpty()) {
                int[] curBomb = queue.poll();
                count++;
                int x1 = curBomb[0];
                int y1 = curBomb[1];
                int r1 = curBomb[2];

                for (int j = 0; j < bombs.length; j++) {
                    if (visited[j]) continue;
                    int[] nextBomb = bombs[j];
                    int x2 = nextBomb[0];
                    int y2 = nextBomb[1];
                    if (getDistance(x1, y1, x2, y2) <= r1) {
                        visited[j] = true;
                        queue.add(nextBomb);
                    }
                }
            }
            result = Math.max(result, count);
        }

        return result;
    }

    private static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(1.0 * x1 - x2, 2) + Math.pow(1.0 * y1 - y2, 2));
    }
}
