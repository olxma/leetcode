package com.leetcode.solution;

/**
 * <b>Minimum Flips to Make a OR b Equal to c</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given 3 positives numbers a, b and c.
 * Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.</p>
 *
 * @see <a href="https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/">
 * 1318. Minimum Flips to Make a OR b Equal to c</a>
 */
public class MinimumFlipsToMakeAOrBEqualToCSolution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (getBit(c, i) == 1) {
                if (getBit(a, i) == 0 && getBit(b, i) == 0) {
                    count++;
                }
            } else {
                if (getBit(a, i) == 1) {
                    count++;
                }
                if (getBit(b, i) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int getBit(int val, int pos) {
        return (val >> pos) & 1;
    }
}
