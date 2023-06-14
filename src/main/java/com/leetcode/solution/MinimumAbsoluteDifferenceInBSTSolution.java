package com.leetcode.solution;

import com.leetcode.model.TreeNode;

/**
 * <b>Minimum Absolute Difference in BST</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given the root of a Binary Search Tree (BST), return the minimum absolute difference
 * between the values of any two different nodes in the tree.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">
 * 530. Minimum Absolute Difference in BST</a>
 */
public class MinimumAbsoluteDifferenceInBSTSolution {
    public int getMinimumDifference(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        if (root.left != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - getMaxValue(root.left)));
            minDiff = Math.min(minDiff, getMinimumDifference(root.left));
        }
        if (root.right != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - getMinValue(root.right)));
            minDiff = Math.min(minDiff, getMinimumDifference(root.right));
        }
        return minDiff;
    }

    private static int getMaxValue(TreeNode node) {
        if (node.right != null) {
            return getMaxValue(node.right);
        }
        return node.val;
    }

    private static int getMinValue(TreeNode node) {
        if (node.left != null) {
            return getMinValue(node.left);
        }
        return node.val;
    }
}
