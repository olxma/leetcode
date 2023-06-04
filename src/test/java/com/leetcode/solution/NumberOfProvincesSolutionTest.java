package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfProvincesSolutionTest {
    private NumberOfProvincesSolution soultion;


    @BeforeEach
    void setUp() {
        soultion = new NumberOfProvincesSolution();
    }

    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, 2),
                Arguments.of(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void findCircleNum(int[][] isConnected, int expected) {
        int result = soultion.findCircleNum(isConnected);

        assertEquals(expected, result);
    }
}