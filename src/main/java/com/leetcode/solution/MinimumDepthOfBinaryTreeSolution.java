package com.leetcode.solution;

import com.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <b>Minimum Depth of Binary Tree</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given a binary tree, find its minimum depth.</p>
 * <p>The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.</p>
 * <p>Note: A leaf is a node with no children.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">111. Minimum Depth of Binary Tree</a>
 */
public class MinimumDepthOfBinaryTreeSolution {
    public int minDepth(TreeNode root) {
        Queue<TreeNodeWithDepth> queue = new ArrayDeque<>();

        if (root != null) {
            queue.offer(new TreeNodeWithDepth(root, 1));
        }
        while (!queue.isEmpty()) {
            TreeNodeWithDepth node = queue.poll();
            if (node.left == null && node.right == null) {
                return node.depth;
            }
            if (node.left != null) {
                queue.offer(new TreeNodeWithDepth(node.left, node.depth + 1));
            }
            if (node.right != null) {
                queue.offer(new TreeNodeWithDepth(node.right, node.depth + 1));
            }
        }
        return 0;
    }

    private static class TreeNodeWithDepth extends TreeNode {
        int depth;

        TreeNodeWithDepth(TreeNode node, int depth) {
            super(node.val, node.left, node.right);
            this.depth = depth;
        }
    }
}
