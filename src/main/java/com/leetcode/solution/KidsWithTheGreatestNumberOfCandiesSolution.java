package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Kids With the Greatest Number of Candies</b>
 * <p>Level: <i>Easy</i></p>
 * <p>There are n kids with candies. You are given an integer array candies,
 * where each candies[i] represents the number of candies the i<sup>th</sup> kid has,
 * and an integer extraCandies, denoting the number of extra candies that you have.</p>
 *
 * <p>Return a boolean array result of length n, where result[i] is true if,
 * after giving the i<sup>th</sup> kid all the extraCandies,
 * they will have the greatest number of candies among all the kids, or false otherwise.</p>
 *
 * <p>Note that multiple kids can have the greatest number of candies.</p>
 *
 * @see <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/">
 * 1431. Kids With the Greatest Number of Candies</a>
 */
public class KidsWithTheGreatestNumberOfCandiesSolution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}
