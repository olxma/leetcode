package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumWidthOfBinaryTreeSolutionTest {
    private MaximumWidthOfBinaryTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumWidthOfBinaryTreeSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,3,2,5,3,null,9; 4",
            "1,3,2,5,null,null,9,6,null,7; 7",
            "1,3,2,5; 2",
            "1,1,1,1,1,1,1,null,null,null,1,null,null,null,null,2,2,2,2,2,2,2,null,2,null,null,2,null,2; 8"
    }, delimiter = ';')
    void widthOfBinaryTree(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        int result = solution.widthOfBinaryTree(root);

        assertEquals(expected, result);
    }
}