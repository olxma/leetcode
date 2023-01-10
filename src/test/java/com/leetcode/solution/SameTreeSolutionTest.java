package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SameTreeSolutionTest {
    private static SameTreeSolution solution;

    @BeforeEach
    void setUp() {
        solution = new SameTreeSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3; 1,2,3;    true",
            "1,2;   1,null,2; false",
            "1,2,1; 1,1,2;    false"
    }, delimiter = ';')
    void isSameTree(@ConvertWith(TreeNodeConverter.class) TreeNode p,
                    @ConvertWith(TreeNodeConverter.class) TreeNode q,
                    boolean expected) {
        boolean result = solution.isSameTree(p, q);

        assertEquals(expected, result);
    }
}