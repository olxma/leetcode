package com.leetcode.solution;

/**
 * <b>Add Digits</b>
 * <p>Level: <i>Easy</i></p>
 * <p>Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.</p>
 *
 * @see <a href="https://leetcode.com/problems/add-digits/">258. Add Digits</a>
 */
public class AddDigitsSolution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }
}
