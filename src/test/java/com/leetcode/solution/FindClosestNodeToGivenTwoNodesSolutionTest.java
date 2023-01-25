package com.leetcode.solution;

import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindClosestNodeToGivenTwoNodesSolutionTest {
    private static FindClosestNodeToGivenTwoNodesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new FindClosestNodeToGivenTwoNodesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,2,3,-1;                  0;  1;  2",
            "1,2,-1;                    0;  2;  2",
            "5,-1,3,4,5,6,-1,-1,4,3;    0;  0;  0",
            "4,3,0,5,3,-1;              4;  0;  4",
            "5,3,1,0,2,4,5;             3;  2;  3"
    }, delimiter = ';')
    void closestMeetingNode(@ConvertWith(IntegerArrayConverter.class) int[] edges, int node1, int node2, int expected) {
        int result = solution.closestMeetingNode(edges, node1, node2);

        assertEquals(expected, result);
    }
}