package com.leetcode.solution;

import com.leetcode.model.TreeNode;

/**
 * <b>Maximum Product of Splitted Binary Tree</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>Given the root of a binary tree {@link TreeNode},
 * split the binary tree into two subtrees by removing one edge such
 * that the product of the sums of the subtrees is maximized.</p>
 *
 * <p>Return the maximum product of the sums of the two subtrees.
 * Since the answer may be too large, return it modulo 10<sup>9</sup> + 7.</p>
 *
 * <p>Note that you need to maximize the answer before taking the mod and not after taking it.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/">
 * 1339. Maximum Product of Splitted Binary Tree</a>
 */
public class MaximumProductOfSplittedBinaryTreeSolution {
    private static final int MOD = (int) Math.pow(10, 9) + 7;
    private long max = 0;

    public int maxProduct(TreeNode root) {
        long totalSum = getSum(root);
        traversal(root, totalSum);
        return (int) (max % MOD);
    }

    private long traversal(TreeNode node, long total) {
        if (node == null) {
            return 0;
        }

        if (isLeaf(node)) {
            max = Math.max(max, node.val);
            return node.val;
        }

        long leftSum = traversal(node.left, total);
        long rightSum = traversal(node.right, total);

        max = Math.max(
                max,
                Math.max(
                        (total - leftSum) * leftSum,
                        (total - rightSum) * rightSum));

        return node.val + leftSum + rightSum;
    }

    private static int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getSum(node.left) + getSum(node.right);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
