package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * <b>Lexicographically Smallest Equivalent String</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given two strings of the same length s1 and s2 and a string baseStr.</p>
 *
 * <p>We say s1[i] and s2[i] are equivalent characters.</p>
 *
 * <ul><li>For example, if s1 = "abc" and s2 = "cde",
 * then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.</li></ul>
 *
 * <p>Equivalent characters follow the usual rules of any equivalence relation:</p>
 *
 * <ul>
 *     <li><b>Reflexivity:</b> 'a' == 'a'.</li>
 *     <li><b>Symmetry:</b> 'a' == 'b' implies 'b' == 'a'.</li>
 *     <li><b>Transitivity:</b> 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.</li>
 * </ul>
 *
 * <p>For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab"
 * are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string
 * of baseStr.</p>
 *
 * <p>Return the lexicographically smallest equivalent string of baseStr
 * by using the equivalency information from s1 and s2.</p>
 *
 * @see <a href="https://leetcode.com/problems/lexicographically-smallest-equivalent-string/">
 * 1061. Lexicographically Smallest Equivalent String</a>
 */
public class LexicographicallySmallestEquivalentStringSolution {
    // it can be improved since it's not the fastest solution
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.computeIfAbsent(c1, val -> new TreeSet<>()).add(c2);
            map.computeIfAbsent(c2, val -> new TreeSet<>()).add(c1);
        }
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            for (Character character : entry.getValue()) {
                map.computeIfAbsent(character, val -> new TreeSet<>()).addAll(entry.getValue());
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            Set<Character> characters = map.get(c);
            if (characters == null) {
                builder.append(c);
            } else {
                builder.append(characters.iterator().next());
            }
        }

        return builder.toString();
    }
}
