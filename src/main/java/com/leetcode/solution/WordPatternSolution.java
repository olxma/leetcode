package com.leetcode.solution;

import java.util.*;

/**
 * <b>Word Pattern</b>
 * <p>Level: <i>Easy</i></p>
 *
 * <p>Given a pattern and a string s, find if s follows the same pattern.</p>
 * <p>Here follow means a full match, such that there is a bijection between a letter in pattern
 * and a non-empty word in s.</p>
 *
 * @see <a href="https://leetcode.com/problems/word-pattern/">290. Word Pattern</a>
 */
public class WordPatternSolution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\s");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = map.get(c);
            if (w == null && !usedWords.contains(words[i])) {
                map.put(c, words[i]);
                usedWords.add(words[i]);
            } else if (!Objects.equals(words[i], w)) {
                return false;
            }
        }
        return true;
    }
}
