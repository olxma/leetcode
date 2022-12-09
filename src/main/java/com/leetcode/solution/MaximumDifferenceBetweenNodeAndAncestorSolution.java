package com.leetcode.solution;

import com.leetcode.model.TreeNode;

import static java.lang.Math.*;

/**
 * <b>Maximum Difference Between Node and Ancestor</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>Given the root of a binary tree {@link TreeNode}, find the maximum value v for which
 * there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.</p>
 * <p>A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/">
 * 1026. Maximum Difference Between Node and Ancestor</a>
 */
public class MaximumDifferenceBetweenNodeAndAncestorSolution {
    public int maxAncestorDiff(TreeNode root) {
        return max(
                searchMaxDiff(root.val, root.val, 0, root.left),
                searchMaxDiff(root.val, root.val, 0, root.right));
    }

    private static int searchMaxDiff(int minVal, int maxVal, int maxDiff, TreeNode node) {
        if (node == null) {
            return maxDiff;
        }
        maxDiff = max(maxDiff, getCurrentMaxDiff(minVal, maxVal, node));
        return max(
                searchMaxDiff(min(node.val, minVal), max(node.val, maxVal), maxDiff, node.left),
                searchMaxDiff(min(node.val, minVal), max(node.val, maxVal), maxDiff, node.right));
    }

    private static int getCurrentMaxDiff(int minVal, int maxVal, TreeNode node) {
        return max(abs(minVal - node.val), abs(maxVal - node.val));
    }
}
