package com.leetcode.solution;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Leaf-Similar Trees</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Consider all the leaves of a binary tree {@link TreeNode}, from left to right order,
 * the values of those leaves form a leaf value sequence.</p>
 *
 * <p>For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).</p>
 * <p>Two binary trees are considered leaf-similar if their leaf value sequence is the same.</p>
 * <p>Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.</p>
 *
 * @see <a href="https://leetcode.com/problems/leaf-similar-trees/">872. Leaf-Similar Trees</a>
 */
public class LeafSimilarTreesSolution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = getAllLeafs(root1);
        List<Integer> leafs2 = getAllLeafs(root2);
        return leafs1.equals(leafs2);
    }

    private static List<Integer> getAllLeafs(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        findLeafs(root, values);
        return values;
    }

    private static void findLeafs(TreeNode node, List<Integer> values) {
        if (node != null) {
            if (node.left != null) {
                findLeafs(node.left, values);
            }
            if (node.right != null) {
                findLeafs(node.right, values);
            }
            if (isLeaf(node)) {
                values.add(node.val);
            }
        }
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
