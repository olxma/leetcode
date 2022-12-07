package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSumOfBSTSolutionTest {
    private static RangeSumOfBSTSolution solution;

    @BeforeAll
    public static void init() {
        solution = new RangeSumOfBSTSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10,5,15,3,7,null,18; 7; 15; 32",
            "10,5,15,3,7,13,18,1,null,6; 6; 10; 23",
    }, delimiter = ';')
    void rangeSumBST(@ConvertWith(TreeNodeConverter.class)TreeNode root, int low, int high, int expected) {
        int result = solution.rangeSumBST(root, low, high);

        assertEquals(expected, result);
    }
}