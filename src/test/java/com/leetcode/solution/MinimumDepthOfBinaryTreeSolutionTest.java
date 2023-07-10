package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumDepthOfBinaryTreeSolutionTest {
    private MinimumDepthOfBinaryTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumDepthOfBinaryTreeSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,9,20,null,null,15,7; 2",
            "2,null,3,null,4,null,5,null,6; 5"
    }, delimiter = ';')
    void minDepth(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        int result = solution.minDepth(root);

        assertEquals(expected, result);
    }
}