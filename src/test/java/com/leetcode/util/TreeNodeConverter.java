package com.leetcode.util;

import com.leetcode.model.TreeNode;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class TreeNodeConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && TreeNode.class.isAssignableFrom(targetType)) {
            String[] split = ((String) source).split("\\s*,\\s*");
            return buildTree(split);
        } else {
            throw new IllegalArgumentException(
                    String.format("Conversion from %s to %s not supported.", source.getClass(), targetType));
        }
    }

    private static TreeNode buildTree(String[] input) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = null;
        int index = 0;

        if (index < input.length) {
            root = stackValueAsTreeNode(stack, input[index]);
            index++;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (index < input.length) {
                node.left = stackValueAsTreeNode(stack, input[index]);
                index++;
            }

            if (index < input.length) {
                node.right = stackValueAsTreeNode(stack, input[index]);
                index++;
            }
        }
        return root;
    }

    private static TreeNode stackValueAsTreeNode(Deque<TreeNode> stack, String value) {
        TreeNode node = getTreeNode(value);
        if (node != null) {
            stack.add(node);
        }
        return node;
    }

    private static TreeNode getTreeNode(String value) {
        TreeNode node = null;
        if (!Objects.equals(value, "null")) {
            node = new TreeNode(Integer.parseInt(value));
        }
        return node;
    }


}
