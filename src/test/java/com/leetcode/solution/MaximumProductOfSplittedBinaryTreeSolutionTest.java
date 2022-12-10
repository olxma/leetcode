package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductOfSplittedBinaryTreeSolutionTest {
    private MaximumProductOfSplittedBinaryTreeSolution solution;

    @BeforeEach
    public void init() {
        solution = new MaximumProductOfSplittedBinaryTreeSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6; 110",
            "1,null,2,3,4,null,null,5,6; 90",
            "5,6,6,null,null,8,6,10,null,5; 504"
    }, delimiter = ';')
    void maxProduct(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        long result = solution.maxProduct(root);

        assertEquals(expected, result);
    }
}