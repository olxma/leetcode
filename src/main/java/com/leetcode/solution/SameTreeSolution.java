package com.leetcode.solution;

import com.leetcode.model.TreeNode;

/**
 * <b>Same Tree</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given the roots of two binary trees p and q,
 * write a function to check if they are the same or not.</p>
 *
 * <p>Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.</p>
 *
 * @see <a href="https://leetcode.com/problems/same-tree/">100. Same Tree</a>
 */
public class SameTreeSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
