package com.leetcode.solution;

import com.leetcode.model.TreeNode;

/**
 * <b>Longest ZigZag Path in a Binary Tree</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given the root of a binary tree.</p>
 * <p>A ZigZag path for a binary tree is defined as follow:</p>
 * <ul>
 *     <li>Choose any node in the binary tree and a direction (right or left).</li>
 *     <li>If the current direction is right, move to the right child of the current node;
 *     otherwise, move to the left child.</li>
 *     <li>Change the direction from right to left or from left to right.</li>
 *     <li>Repeat the second and third steps until you can't move in the tree.</li>
 * </ul>
 *
 * <p>Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).</p>
 * <p>Return the longest ZigZag path contained in that tree.</p>
 *
 * @see <a href="https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/">
 * 1372. Longest ZigZag Path in a Binary Tree</a>
 */
public class LongestZigZagPathInABinaryTreeSolution {
    private int max;

    public int longestZigZag(TreeNode root) {
        bfs(root.left, false, 1);
        bfs(root.right, true, 1);
        return max;
    }

    private int bfs(TreeNode node, boolean left, int nodes) {
        if (node == null) return nodes - 1;
        if (left) {
            max = Math.max(max, bfs(node.left, false, nodes + 1));
            max = Math.max(max, bfs(node.right, true, 1));
        } else {
            max = Math.max(max, bfs(node.right, true, nodes + 1));
            max = Math.max(max, bfs(node.left, false, 1));
        }
        return max;
    }
}
