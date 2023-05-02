package com.leetcode.solution;

/**
 * <b>Sign of the Product of an Array</b>
 * <p>Level: <i>Easy</i></p>
 * <p>There is a function signFunc(x) that returns:</p>
 *
 * <ul>
 *     <li>1 if x is positive.</li>
 *     <li>-1 if x is negative.</li>
 *     <li>0 if x is equal to 0.</li>
 * </ul>
 *
 * <p>You are given an integer array nums. Let product be the product of all values in the array nums.</p>
 * <p>Return signFunc(product).</p>
 *
 * @see <a href="https://leetcode.com/problems/sign-of-the-product-of-an-array/">
 * 1822. Sign of the Product of an Array</a>
 */
public class SignOfTheProductOfAnArraySolution {
    public int arraySign(int[] nums) {
        boolean isNegative = false;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                isNegative = !isNegative;
            }
        }
        return isNegative ? -1 : 1;
    }
}
