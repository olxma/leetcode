package com.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>Longest Path With Different Adjacent Characters</b>
 * <p>Level: <i>Hard</i></p>
 * <p>You are given a tree (i.e. a connected, undirected graph that has no cycles)
 * rooted at node 0 consisting of n nodes numbered from 0 to n - 1.
 * The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i.
 * Since node 0 is the root, parent[0] == -1.</p>
 *
 * <p>You are also given a string s of length n, where s[i] is the character assigned to node i.</p>
 *
 * <p>Return the length of the longest path in the tree such that no pair of adjacent nodes
 * on the path have the same character assigned to them.</p>
 *
 * @see <a href="https://leetcode.com/problems/longest-path-with-different-adjacent-characters/">
 * 2246. Longest Path With Different Adjacent Characters</a>
 */
public class LongestPathWithDifferentAdjacentCharactersSolution {
    //I could not solve this problem by myself, this is an official solution from here:
    // https://leetcode.com/problems/longest-path-with-different-adjacent-characters/solutions/2889382/longest-path-with-different-adjacent-characters/
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        int[] childrenCount = new int[n];
        // Start from node 1, since the root node does not have a parent.
        for (int node = 1; node < n; node++) {
            childrenCount[parent[node]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int longestPath = 1;
        int[][] longestChains = new int[n][2];

        for (int node = 1; node < n; node++) {
            // Push all the leaf nodes in the queue.
            if (childrenCount[node] == 0) {
                longestChains[node][0] = 1;
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            int currentNode = q.poll();
            int par = parent[currentNode];
            // Get the number of nodes in the longest chain starting from the currentNode,
            // including the currentNode.
            int longestChainStartingFromCurrNode = longestChains[currentNode][0];
            if (s.charAt(currentNode) != s.charAt(par)) {
                // Modify the longest chain and second-longest chain if
                // longestChainStartingFromCurrNode is bigger.
                if (longestChainStartingFromCurrNode > longestChains[par][0]) {
                    longestChains[par][1] = longestChains[par][0];
                    longestChains[par][0] = longestChainStartingFromCurrNode;
                } else if (longestChainStartingFromCurrNode > longestChains[par][1]) {
                    longestChains[par][1] = longestChainStartingFromCurrNode;
                }
            }

            longestPath = Math.max(longestPath, longestChains[par][0] + longestChains[par][1] + 1);
            childrenCount[par]--;

            if (childrenCount[par] == 0 && par != 0) {
                longestChains[par][0]++;
                q.offer(par);
            }
        }

        return longestPath;
    }
}
