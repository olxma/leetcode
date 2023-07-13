package com.leetcode.solution;

import java.util.*;

/**
 * <b>Course Schedule</b>
 * <p>Level: <i>Medium</i></p>
 * <p>There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>] indicates
 * that you must take course bi first if you want to take course a<sub>i</sub>.</p>
 *
 * <ul>
 *     <li>For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.</li>
 * </ul>
 *
 * <p>Return true if you can finish all courses. Otherwise, return false.</p>
 *
 * @see <a href="https://leetcode.com/problems/course-schedule/">207. Course Schedule</a>
 */
public class CourseScheduleSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            graph.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCycled(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCycled(int course, Map<Integer, List<Integer>> graph, int[] visited) {
        if (visited[course] == 1) return true;
        if (visited[course] == 2) return false;
        visited[course] = 1;

        List<Integer> prerequisites = graph.get(course);
        if (prerequisites != null) {
            for (int prerequisite : prerequisites) {
                if (isCycled(prerequisite, graph, visited)) {
                    return true;
                }
            }
        }

        visited[course] = 2;
        return false;
    }
}
