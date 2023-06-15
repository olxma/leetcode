package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumLevelSumOfABinaryTreeSolutionTest {
    private MaximumLevelSumOfABinaryTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MaximumLevelSumOfABinaryTreeSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,7,0,7,-8,null,null; 2",
            "989,null,10250,98693,-89388,null,null,null,-32127; 2"
    }, delimiter = ';')
    void maxLevelSum(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        int result = solution.maxLevelSum(root);

        assertEquals(expected, result);
    }
}