package com.leetcode.solution;

import com.leetcode.util.BooleanListConverter;
import com.leetcode.util.IntegerArrayConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KidsWithTheGreatestNumberOfCandiesSolutionTest {
    private KidsWithTheGreatestNumberOfCandiesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new KidsWithTheGreatestNumberOfCandiesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2,3,5,1,3; 3;  true,true,true,false,true",
            "4,2,1,1,2; 1;  true,false,false,false,false",
            "12,1,12;   10; true,false,true"
    }, delimiter = ';')
    void kidsWithCandies(@ConvertWith(IntegerArrayConverter.class) int[] candies, int extraCandies,
                         @ConvertWith(BooleanListConverter.class) List<Boolean> expected) {
        List<Boolean> result = solution.kidsWithCandies(candies, extraCandies);

        assertEquals(expected, result);
    }
}