package com.leetcode.solution;

import java.util.Arrays;

/**
 * <b>Boats to Save People</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You are given an array people where people[i] is the weight of the i<sup>th</sup> person,
 * and an infinite number of boats where each boat can carry a maximum weight of limit.
 * Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.</p>
 *
 * <p>Return the minimum number of boats to carry every given person.</p>
 *
 * @see <a href="https://leetcode.com/problems/boats-to-save-people/">881. Boats to Save People</a>
 */
public class BoatsToSavePeopleSolution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int result = 0;
        while (i <= j) {
            int boat = people[j--];
            int peopleInBoat = 1;
            while (peopleInBoat < 2 && j >= i && boat + people[j] <= limit) {
                boat += people[j--];
                peopleInBoat++;
            }
            while (peopleInBoat < 2 && i < j && boat + people[i] <= limit) {
                boat += people[i++];
                peopleInBoat++;
            }
            result++;
        }
        return result;
    }
}
