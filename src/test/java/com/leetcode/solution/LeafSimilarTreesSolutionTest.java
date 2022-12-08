package com.leetcode.solution;

import com.leetcode.model.TreeNode;
import com.leetcode.util.TreeNodeConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeafSimilarTreesSolutionTest {
    private static LeafSimilarTreesSolution solution;

    @BeforeAll
    public static void init() {
        solution = new LeafSimilarTreesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,5,1,6,2,9,8,null,null,7,4; 3,5,1,6,7,4,2,null,null,null,null,null,null,9,8; true",
            "1,2,3; 1,3,2; false",
            "3,5,1,6,7,4,2,null,null,null,null,null,null,9,11,null,null,8,10; 3,5,1,6,2,9,8,null,null,7,4; false"
    }, delimiter = ';')
    void leafSimilar(@ConvertWith(TreeNodeConverter.class) TreeNode root1,
                     @ConvertWith(TreeNodeConverter.class) TreeNode root2,
                     boolean expected) {
        boolean result = solution.leafSimilar(root1, root2);

        assertEquals(expected, result);
    }
}