package com.leetcode.solution;

import com.leetcode.model.TreeNode;

/**
 * <b>Binary Tree Maximum Path Sum</b>
 * <p>Level: <i>Hard</i></p>
 * <p>A path in a binary tree {@link TreeNode} is a sequence of nodes where each pair of adjacent nodes
 * in the sequence has an edge connecting them. A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.</p>
 *
 * <p>The path sum of a path is the sum of the node's values in the path.</p>
 *
 * <p>Given the root of a binary tree, return the maximum path sum of any non-empty path.</p>
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">
 * 124. Binary Tree Maximum Path Sum</a>
 */
public class BinaryTreeMaximumPathSumSolution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxSumFor(root);
        return max;
    }

    private int findMaxSumFor(TreeNode node) {
        if (node.left == null && node.right == null) {
            max = Math.max(max, node.val);
            return node.val;
        }

        int left = getMaxSumIfNotNullFor(node.left);
        int right = getMaxSumIfNotNullFor(node.right);
        checkMax(node.val, left, right);

        int leftSum = getSafeValue(left);
        int rightSum = getSafeValue(right);
        int leftPathSum = leftSum + node.val;
        int rightPathSum = rightSum + node.val;
        checkMax(leftSum + rightSum + node.val, leftPathSum, rightPathSum);

        return Math.max(node.val, Math.max(leftPathSum, rightPathSum));
    }

    private int getMaxSumIfNotNullFor(TreeNode node) {
        return node != null ? findMaxSumFor(node) : Integer.MIN_VALUE;
    }

    private static int getSafeValue(int left) {
        return left == Integer.MIN_VALUE ? 0 : left;
    }

    private void checkMax(int val, int left, int right) {
        max = Math.max(max, val);
        max = Math.max(max, left);
        max = Math.max(max, right);
    }
}
