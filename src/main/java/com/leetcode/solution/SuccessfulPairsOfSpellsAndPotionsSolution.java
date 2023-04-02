package com.leetcode.solution;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * <b>Successful Pairs of Spells and Potions</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given two positive integer arrays spells and potions, of length n and m respectively,
 * where spells[i] represents the strength of the i<sup>th</sup> spell and potions[j]
 * represents the strength of the j<sup>th</sup> potion.</p>
 *
 * <p>ou are also given an integer success. A spell and potion pair is considered successful
 * if the product of their strengths is at least success.</p>
 *
 * <p>Return an integer array pairs of length n where pairs[i] is the number of potions
 * that will form a successful pair with the i<sup>th</sup> spell.</p>
 *
 * @see <a href="https://leetcode.com/problems/successful-pairs-of-spells-and-potions/">
 * 2300. Successful Pairs of Spells and Potions</a>
 */
public class SuccessfulPairsOfSpellsAndPotionsSolution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(Long.MAX_VALUE, potions.length);
        for (int i = potions.length - 1; i >= 0; i--) {
            map.put((long) potions[i], i);
        }
        for (int i = 0; i < spells.length; i++) {
            long need = (success + spells[i] - 1) / spells[i];
            spells[i] = potions.length - map.ceilingEntry(need).getValue();
        }
        return spells;
    }
}
