package com.leetcode.solution;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Binary Tree Preorder Traversal</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given the root of a binary tree, return the preorder traversal of its nodes' values.</p>
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/description/">
 * 144. Binary Tree Preorder Traversal</a>
 */
public class BinaryTreePreorderTraversalSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverse(root, result);
        return result;
    }

    private static void traverse(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);
        traverse(node.left, result);
        traverse(node.right, result);
    }
}