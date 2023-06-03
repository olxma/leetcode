package com.leetcode.solution;

import java.util.*;

/**
 * <b>Time Needed to Inform All Employees</b>
 * <p>Level: <i>Medium</i></p>
 * <p>A company has n employees with a unique ID for each employee from 0 to n - 1.
 * The head of the company is the one with headID.</p>
 *
 * <p>Each employee has one direct manager given in the manager array
 * where manager[i] is the direct manager of the i-th employee, manager[headID] = -1.
 * Also, it is guaranteed that the subordination relationships have a tree structure.</p>
 *
 * <p>The head of the company wants to inform all the company employees of an urgent piece of news.
 * He will inform his direct subordinates, and they will inform their subordinates,
 * and so on until all employees know about the urgent news.</p>
 *
 * <p>The i-th employee needs informTime[i] minutes to inform all of his direct subordinates
 * (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).</p>
 *
 * <p>Return the number of minutes needed to inform all the employees about the urgent news.</p>
 *
 * @see <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/">
 * 1376. Time Needed to Inform All Employees</a>
 */
public class TimeNeededToInformAllEmployeesSolution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] < 0) continue;
            tree.computeIfAbsent(manager[i], val -> new ArrayList<>()).add(i);
        }

        int maxTime = 0;
        Node node = new Node(headID, 0);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            maxTime = Math.max(maxTime, node.time);
            List<Integer> children = tree.get(node.id);
            if (children != null) {
                for (Integer child : children) {
                    queue.add(new Node(child, node.time + informTime[node.id]));
                }
            }
        }
        return maxTime;
    }

    private static class Node {
        private final int id;
        private final int time;

        public Node(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}
