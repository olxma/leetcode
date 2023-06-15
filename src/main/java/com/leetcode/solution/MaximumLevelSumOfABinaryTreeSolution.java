package com.leetcode.solution;

import com.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <b>Maximum Level Sum of a Binary Tree</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.</p>
 *
 * <p>Return the smallest level x such that the sum of all the values of nodes at level x is maximal.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/">
 * 1161. Maximum Level Sum of a Binary Tree</a>
 */
public class MaximumLevelSumOfABinaryTreeSolution {
    private int maxSum = Integer.MIN_VALUE;
    private int result;

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> currentLevel = new ArrayDeque<>();
        Queue<TreeNode> nextLevel = new ArrayDeque<>();
        currentLevel.offer(root);
        checkLevel(1, currentLevel, nextLevel);
        return result;
    }

    private void checkLevel(int level, Queue<TreeNode> currentLevel, Queue<TreeNode> nextLevel) {
        int sum = 0;
        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.poll();
            sum += node.val;
            if (node.left != null) {
                nextLevel.offer(node.left);
            }
            if (node.right != null) {
                nextLevel.offer(node.right);
            }
        }
        if (sum > maxSum) {
            maxSum = sum;
            result = level;
        }

        if (!nextLevel.isEmpty()) {
            checkLevel(level + 1, nextLevel, currentLevel);
        }
    }
}
