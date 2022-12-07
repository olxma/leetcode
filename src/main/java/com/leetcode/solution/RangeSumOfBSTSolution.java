package com.leetcode.solution;

import com.leetcode.model.TreeNode;

/**
 * <b>Range Sum of BST</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given the root node of a binary search tree {@link TreeNode} and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].</p>
 *
 * @see <a href="https://leetcode.com/problems/range-sum-of-bst/">938. Range Sum of BST</a>
 */
public class RangeSumOfBSTSolution {
    public int rangeSumBST(TreeNode node, int low, int high) {
        int sum = 0;
        if (node != null) {
            if (inRange(node, low, high)) {
                sum += node.val;
            }
            sum += rangeSumBST(node.left, low, high);
            sum += rangeSumBST(node.right, low, high);
        } else {
            return 0;
        }
        return sum;
    }

    private static boolean inRange(TreeNode root, int low, int high) {
        return root.val >= low && root.val <= high;
    }
}
