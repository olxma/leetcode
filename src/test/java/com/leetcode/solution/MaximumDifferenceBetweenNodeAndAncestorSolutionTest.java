package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDifferenceBetweenNodeAndAncestorSolutionTest {
    private static MaximumDifferenceBetweenNodeAndAncestorSolution solution;

    @BeforeAll
    public static void init() {
        solution = new MaximumDifferenceBetweenNodeAndAncestorSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "8,3,10,1,6,null,14,null,null,4,7,13; 7",
            "1,null,2,null,0,3; 3"
    }, delimiter = ';')
    void maxAncestorDiff(@ConvertWith(TreeNodeConverter.class) TreeNode root, int expected) {
        int result = solution.maxAncestorDiff(root);

        assertEquals(expected, result);
    }
}