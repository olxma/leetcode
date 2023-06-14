package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumAbsoluteDifferenceInBSTSolutionTest {
    private MinimumAbsoluteDifferenceInBSTSolution solution;

    @BeforeEach
    void setUp() {
        solution = new MinimumAbsoluteDifferenceInBSTSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4,2,6,1,3; 1",
            "1,0,48,null,null,12,49; 1",
            "236,104,701,null,227,null,911; 9",
            "543,384,652,null,445,null,699; 47"
    }, delimiter = ';')
    void getMinimumDifference(@ConvertWith(TreeNodeConverter.class) TreeNode root,
                              int expected) {
        int result = solution.getMinimumDifference(root);

        assertEquals(expected, result);
    }
}