package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.IntegerListConverter;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreePreorderTraversalSolutionTest {
    private BinaryTreePreorderTraversalSolution solution;

    @BeforeEach
    void setUp() {
        solution = new BinaryTreePreorderTraversalSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,null,2,3; 1,2,3",
            "1; 1",
            "null; null",
            "1,4,3,2; 1,4,2,3"
    }, delimiter = ';')
    void preorderTraversal(@ConvertWith(TreeNodeConverter.class) TreeNode root,
                           @ConvertWith(IntegerListConverter.class) List<Integer> expected) {
        List<Integer> result = solution.preorderTraversal(root);

        assertEquals(expected, result);
    }
}