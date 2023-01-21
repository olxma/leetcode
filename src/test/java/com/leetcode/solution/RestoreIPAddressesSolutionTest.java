package com.leetcode.solution;

import com.leetcode.util.StringListConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestoreIPAddressesSolutionTest {
    private static RestoreIPAddressesSolution solution;

    @BeforeEach
    void setUp() {
        solution = new RestoreIPAddressesSolution();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "25525511135;   255.255.11.135, 255.255.111.35",
            "0000;          0.0.0.0",
            "101023;        1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3"
    }, delimiter = ';')
    void restoreIpAddresses(String s, @ConvertWith(StringListConverter.class) List<String> expected) {
        List<String> result = solution.restoreIpAddresses(s);

        assertEquals(expected, result);
    }
}