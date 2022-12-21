package com.leetcode.util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class GraphUtil {
    /**
     * Mapping all related nodes to each other
     * @param edges relations
     * @return map of linked nodes
     */
    public static Map<Integer, List<Integer>> getLinkedNodeMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            map.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }
        return map;
    }
}
