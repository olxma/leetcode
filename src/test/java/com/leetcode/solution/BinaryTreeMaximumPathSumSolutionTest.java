package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeMaximumPathSumSolutionTest {
    private BinaryTreeMaximumPathSumSolution solution;

    @BeforeEach
    public void init() {
        solution = new BinaryTreeMaximumPathSumSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3; 6",
            "-10,9,20,null,null,15,7; 42",
            "-3; -3",
            "2,-1,-2; 2",
            "5,4,8,11,null,13,4,7,2,null,null,null,1; 48",
            "-2,-1; -1",
            "1,-2,3; 4",
            "1,2,null,3,null,4,null,5; 15",
            "-1,-2,10,-6,null,-3,-6; 10",
            "9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6; 16",
            "-6,null,-2,null,9,-1,5,-4,null,-1; 14",
            "-4,null,-6,-8,-7,null,null,null,-8; -4"
    }, delimiter = ';')
    void maxPathSum(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        int result = solution.maxPathSum(root);

        assertEquals(expected, result);
    }
}