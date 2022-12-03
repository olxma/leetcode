package com.leetcode.solution;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * <b>Sort Characters By Frequency</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.</p>
 *
 * <p>Return the sorted string. If there are multiple answers, return any of them.</p>
 *
 * @see <a href="https://leetcode.com/problems/sort-characters-by-frequency/">451. Sort Characters By Frequency</a>
 */
public class SortCharactersByFrequencySolution {
    private static final String EMPTY_STRING = "";

    public String frequencySort(String s) {
        return getStringSortedBySequenceLength(getCharSequences(s));
    }

    private static Collection<StringBuilder> getCharSequences(String s) {
        Map<Character, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.compute(c, createOrAppendIfExist(c));
        }
        return map.values();
    }

    private static BiFunction<Character, StringBuilder, StringBuilder> createOrAppendIfExist(char c) {
        return (k, v) -> v == null ? new StringBuilder(String.valueOf(c)) : v.append(c);
    }

    private static String getStringSortedBySequenceLength(Collection<StringBuilder> sequences) {
        return sequences.stream()
                .sorted(Comparator.comparing(StringBuilder::length).reversed())
                .reduce(StringBuilder::append)
                .map(StringBuilder::toString)
                .orElse(EMPTY_STRING);
    }
}