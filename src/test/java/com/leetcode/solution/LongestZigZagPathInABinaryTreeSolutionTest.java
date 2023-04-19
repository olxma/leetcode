package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestZigZagPathInABinaryTreeSolutionTest {
    private LongestZigZagPathInABinaryTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new LongestZigZagPathInABinaryTreeSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1; 3",
            "1,1,1,null,1,null,null,1,1,null,1; 4",
            "10,7,10,7,6,2,5,3,4,6,2,7,7,9,null,69,5,7,5,null,null,5,5,2,5,1,null,null,2,10,4,3,null,4,1,null,2,6,null,3,8,null,2,7,1,null,null,null,null,10,10,4,2,null,null,10,1,null,1,null,null,null,null,null,3,null,null,3,4,null,8,null,6,6,10,8,null,4,2,10,10,9,7,10,1,null,9,null,null,4,null,null,null,4,null,null,null,9,null,5,2,3,2,10,9,null,7,null,1,4,null,3,null,null,9,null,null,null,null,null,null,null,null,null,null,1,2,null,4,null,null,6,null,6,6,null,null,null,null,1,null,null,null,2,8,null,null,null,null,5,8,4,2,null,null,null,null,6,9,5,5,null,null,5,null,1,2,null,null,null,null,null,null,null,null,null,null,null,null,7,null,null,null,null,4,null,null,6,null,3,null,null,null,1,2; 6"
    }, delimiter = ';')
    void longestZigZag(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        int result = solution.longestZigZag(root);

        assertEquals(expected, result);
    }
}