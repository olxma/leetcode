package com.leetcode.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumberOfNodesInTheSubTreeWithTheSameLabelSolutionTest {
    private static NumberOfNodesInTheSubTreeWithTheSameLabelSolution solution;

    public static Stream<Arguments> provideTestCases() {
        int n1 = 7;
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        String labels1 = "abaedcd";
        int[] expected1 = {2, 1, 1, 1, 1, 1, 1};

        int n2 = 4;
        int[][] edges2 = {{0, 1}, {1, 2}, {0, 3}};
        String labels2 = "bbbb";
        int[] expected2 = {4, 2, 1, 1};

        int n3 = 5;
        int[][] edges3 = {{0, 1}, {0, 2}, {1, 3}, {0, 4}};
        String labels3 = "aabab";
        int[] expected3 = {3, 2, 1, 1, 1};

        int n4 = 7;
        int[][] edges4 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}};
        String labels4 = "aaabaaa";
        int[] expected4 = {6, 5, 4, 1, 3, 2, 1};

        return Stream.of(
                Arguments.of(n1, edges1, labels1, expected1),
                Arguments.of(n2, edges2, labels2, expected2),
                Arguments.of(n3, edges3, labels3, expected3),
                Arguments.of(n4, edges4, labels4, expected4)
        );
    }

    @BeforeEach
    void setUp() {
        solution = new NumberOfNodesInTheSubTreeWithTheSameLabelSolution();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void countSubTrees(int n, int[][] edges, String labels, int[] expected) {
        int[] result = solution.countSubTrees(n, edges, labels);

        assertArrayEquals(result, expected);
    }
}