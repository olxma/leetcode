package com.leetcode.solution;

import com.leetcode.util.StringArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteColumnsToMakeSortedSolutionTest {
    private DeleteColumnsToMakeSortedSolution solution;

    @BeforeEach
    void setUp() {
        solution = new DeleteColumnsToMakeSortedSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "cba,daf,ghi; 1",
            "a,b; 0",
            "zyx,wvu,tsr; 3"
    }, delimiter = ';')
    void minDeletionSize(@ConvertWith(StringArrayConverter.class) String[] strs, int expected) {
        int result = solution.minDeletionSize(strs);

        assertEquals(expected, result);
    }
}