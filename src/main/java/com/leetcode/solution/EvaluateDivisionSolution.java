package com.leetcode.solution;

import java.util.*;

/**
 * <b>Evaluate Division</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [A<sub>i</sub>, B<sub>i</sub>]
 * and values[i] represent the equation A<sub>i</sub> / B<sub>i</sub> = values[i].
 * Each A<sub>i</sub> or B<sub>i</sub> is a string that represents a single variable.</p>
 *
 * <p>You are also given some queries,
 * where queries[j] = [C<sub>j</sub>, D<sub>j</sub>] represents the j<sup>th</sup> query
 * where you must find the answer for C<sub>j</sub> / D<sub>j</sub> = ?.</p>
 *
 * <p>Return the answers to all queries. If a single answer cannot be determined, return -1.0.</p>
 *
 * <p>Note: The input is always valid.
 * You may assume that evaluating the queries will not result in division by zero
 * and that there is no contradiction.</p>
 *
 * @see <a href="https://leetcode.com/problems/evaluate-division/">399. Evaluate Division</a>
 */
public class EvaluateDivisionSolution {
    private Map<String, Map<String, Double>> map;
    private Queue<String> varQueue;
    private Queue<Double> valQueue;
    private Set<String> visited;
    private String target;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String x = eq.get(0);
            String y = eq.get(1);
            map.computeIfAbsent(x, val -> new HashMap<>()).put(y, values[i]);
            map.computeIfAbsent(y, val -> new HashMap<>()).put(x, 1 / values[i]);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = calc(queries.get(i));
        }
        return result;
    }

    private double calc(List<String> query) {
        String x = query.get(0);
        target = query.get(1);
        Map<String, Double> ops = map.get(x);
        if (ops == null) {
            return -1.0;
        }
        if (x.equals(target)) {
            return 1.0;
        }
        Double res = ops.get(target);
        if (res == null) {
            varQueue = new ArrayDeque<>();
            valQueue = new ArrayDeque<>();
            visited = new HashSet<>();
            res = process(x, 1.0);
            if (res != null) {
                return res;
            }
            while (!varQueue.isEmpty()) {
                String cur = varQueue.poll();
                Double val = valQueue.poll();
                if (cur.equals(target)) {
                    return val;
                } else {
                    res = process(cur, val);
                    if (res != null) {
                        return res;
                    }
                }
            }
            return -1.0;
        } else {
            return ops.get(target);
        }
    }

    private Double process(String variable, Double value) {
        for (Map.Entry<String, Double> entry : map.get(variable).entrySet()) {
            if (entry.getKey().equals(target)) {
                return value * entry.getValue();
            }
            if (visited.contains(entry.getKey())) continue;
            visited.add(entry.getKey());
            varQueue.add(entry.getKey());
            valQueue.add(value * entry.getValue());
        }
        return null;
    }
}
