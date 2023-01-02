package com.leetcode.solution;

/**
 * <b>Detect Capital</b>
 * <p>Level: <i>Easy</i></p>
 *
 * <p>We define the usage of capitals in a word to be right when one of the following cases holds:</p>
 *
 * <ul>
 *     <li>All letters in this word are capitals, like "USA".</li>
 *     <li>All letters in this word are not capitals, like "leetcode".</li>
 *     <li>Only the first letter in this word is capital, like "Google".</li>
 * </ul>
 *
 * <p>Given a string word, return true if the usage of capitals in it is right.</p>
 *
 * @see <a href="https://leetcode.com/problems/detect-capital/description/">520. Detect Capital</a>
 */
public class DetectCapitalSolution {
    public boolean detectCapitalUse(String word) {
        boolean isFirstCapital = Character.isUpperCase(word.charAt(0));
        if (word.length() > 1) {
            boolean isSecondCapital = Character.isUpperCase(word.charAt(1));
            if (!isFirstCapital && isSecondCapital) return false;
            for (int i = 2; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isUpperCase(c) != isSecondCapital) {
                    return false;
                }
            }
        }
        return true;
    }
}
