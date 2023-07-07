package com.leetcode.solution;

/**
 * <b>Maximize the Confusion of an Exam</b>
 * <p>Level: <i>Medium</i></p>
 * <p>A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false.
 * He wants to confuse the students by maximizing the number of consecutive questions with the same answer
 * (multiple trues or multiple falses in a row).</p>
 *
 * <p>ou are given a string answerKey, where answerKey[i] is the original answer to the i<sup>th</sup> question.
 * In addition, you are given an integer k, the maximum number of times you may perform the following operation:</p>
 *
 * <ul>
 *     <li>Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').</li>
 * </ul>
 *
 * <p>Return the maximum number of consecutive 'T's or 'F's in the answer key
 * after performing the operation at most k times.</p>
 *
 * @see <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/">
 * 2024. Maximize the Confusion of an Exam</a>
 */
public class MaximizeTheConfusionOfAnExamSolution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int t = 0;
        int f = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < answerKey.length()) {
            char lastChar = answerKey.charAt(right);

            if (lastChar == 'T') {
                t++;
            } else {
                f++;
            }

            int min = Math.min(t, f);
            while (min > k) {
                char firstChar = answerKey.charAt(left);
                if (firstChar == 'T') {
                    t--;
                } else {
                    f--;
                }
                min = Math.min(t, f);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
