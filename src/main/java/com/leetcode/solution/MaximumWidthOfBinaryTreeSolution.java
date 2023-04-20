package com.leetcode.solution;

import com.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b>Maximum Width of Binary Tree</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given the root of a binary tree, return the maximum width of the given tree.</p>
 *
 * <p>The maximum width of a tree is the maximum width among all levels.</p>
 *
 * <p>The width of one level is defined as the length between the end-nodes
 * (the leftmost and rightmost non-null nodes), where the null nodes
 * between the end-nodes that would be present in a complete binary tree
 * extending down to that level are also counted into the length calculation.</p>
 *
 * <p>It is guaranteed that the answer will in the range of a 32-bit signed integer.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">
 * 662. Maximum Width of Binary Tree</a>
 */
public class MaximumWidthOfBinaryTreeSolution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNodeWithPosition> queue = new ArrayDeque<>();
        Deque<TreeNodeWithPosition> buff = new ArrayDeque<>();
        queue.add(new TreeNodeWithPosition(root, 1));
        return getResult(queue, buff);
    }

    private int getResult(Deque<TreeNodeWithPosition> first, Deque<TreeNodeWithPosition> second) {
        int result = first.getLast().position() - first.getFirst().position() + 1;
        while (!first.isEmpty()) {
            TreeNodeWithPosition nodeWithPosition = first.poll();
            if (nodeWithPosition.node().left != null) {
                second.add(new TreeNodeWithPosition(nodeWithPosition.node().left, nodeWithPosition.position() * 2 - 1));
            }
            if (nodeWithPosition.node().right != null) {
                second.add(new TreeNodeWithPosition(nodeWithPosition.node().right, nodeWithPosition.position() * 2));
            }
        }

        if (!second.isEmpty()) {
            result = Math.max(result, getResult(second, first));
        }

        return result;
    }

    private record TreeNodeWithPosition(TreeNode node, int position) {
    }
}
