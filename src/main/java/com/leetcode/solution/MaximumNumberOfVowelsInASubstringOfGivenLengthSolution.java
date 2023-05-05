package com.leetcode.solution;

/**
 * <b>Maximum Number of Vowels in a Substring of Given Length</b>
 * <p>Level: <i>Medium</i></p>
 * <p></p>
 *
 * @see <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">
 * 1456. Maximum Number of Vowels in a Substring of Given Length</a>
 *
 * <p>Given a string s and an integer k,
 * return the maximum number of vowel letters in any substring of s with length k.</p>
 *
 * <p>Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.</p>
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLengthSolution {
    public int maxVowels(String s, int k) {
        int vowels = 0;
        boolean isFirstVowel = isVowel(s.charAt(0));
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            vowels += isVowel(c) ? 1 : 0;
        }
        int max = vowels;

        for (int i = 1; i <= s.length() - k; i++) {
            if (isFirstVowel) vowels--;
            isFirstVowel = isVowel(s.charAt(i));
            if (isVowel(s.charAt(i + k - 1))) vowels++;
            max = Math.max(max, vowels);
        }
        return max;
    }

    private static boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
