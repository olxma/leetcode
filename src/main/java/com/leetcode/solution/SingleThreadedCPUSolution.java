package com.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <b>Single-Threaded CPU</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array tasks,
 * where tasks[i] = [enqueueTime<sub>i</sub>, processingTime<sub>i</sub>] means
 * that the i<sup>th</sup> task will be available to process at enqueueTime<sub>i</sub>
 * and will take processingTime<sub>i</sub> to finish processing.</p>
 *
 * <p>You have a single-threaded CPU that can process at most one task at a time and will act in the following way:</p>
 *
 * <ul>
 *     <li>If the CPU is idle and there are no available tasks to process, the CPU remains idle.</li>
 *     <li>If the CPU is idle and there are available tasks,
 *     the CPU will choose the one with the shortest processing time.
 *     If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.</li>
 *     <li>Once a task is started, the CPU will process the entire task without stopping.</li>
 *     <li>The CPU can finish a task then start a new one instantly.</li>
 * </ul>
 *
 * <p>Return the order in which the CPU will process the tasks.</p>
 *
 * @see <a href="https://leetcode.com/problems/single-threaded-cpu/">1834. Single-Threaded CPU</a>
 */
public class SingleThreadedCPUSolution {
    public int[] getOrder(int[][] tasks) {
        Queue<int[]> nextTask = new PriorityQueue<>(getComparator());

        int[][] sortedTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; ++i) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a[0]));
        int[] tasksProcessingOrder = new int[tasks.length];

        long currentTime = 0;
        int taskIndex = 0;
        int answerIndex = 0;
        while (taskIndex < tasks.length || !nextTask.isEmpty()) {
            if (nextTask.isEmpty() && currentTime < sortedTasks[taskIndex][0]) {
                currentTime = sortedTasks[taskIndex][0];
            }
            while (taskIndex < tasks.length && currentTime >= sortedTasks[taskIndex][0]) {
                nextTask.add(sortedTasks[taskIndex]);
                ++taskIndex;
            }
            if (!nextTask.isEmpty()) {
                int[] task = nextTask.poll();
                int processTime = task[1];
                int index = task[2];
                currentTime += processTime;
                tasksProcessingOrder[answerIndex++] = index;
            }
        }
        return tasksProcessingOrder;
    }

    private static Comparator<int[]> getComparator() {
        return (a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2]));
    }
}
