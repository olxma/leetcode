package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <b>Dota2 Senate</b>
 * <p>Level: <i>Medium</i></p>
 * <p>In the world of Dota2, there are two parties: the Radiant and the Dire.</p>
 *
 * <p>The Dota2 senate consists of senators coming from two parties.
 * Now the Senate wants to decide on a change in the Dota2 game.
 * The voting for this change is a round-based procedure.
 * In each round, each senator can exercise one of the two rights:</p>
 *
 * <ul>
 *     <li><b>Ban one senator's right:</b> A senator can make another senator lose all his rights in this
 *     and all the following rounds.</li>
 *     <li><b>Announce the victory:</b> If this senator found the senators
 *     who still have rights to vote are all from the same party,
 *     he can announce the victory and decide on the change in the game.</li>
 * </ul>
 *
 * <p>Given a string senate representing each senator's party belonging.
 * The character 'R' and 'D' represent the Radiant party and the Dire party.
 * Then if there are n senators, the size of the given string will be n.</p>
 *
 * <p>The round-based procedure starts from the first senator to the last senator in the given order.
 * This procedure will last until the end of voting.
 * All the senators who have lost their rights will be skipped during the procedure.</p>
 *
 * <p>Suppose every senator is smart enough and will play the best strategy for his own party.
 * Predict which party will finally announce the victory and change the Dota2 game.
 * The output should be "Radiant" or "Dire".</p>
 *
 * @see <a href="https://leetcode.com/problems/dota2-senate/">649. Dota2 Senate</a>
 */
public class Dota2SenateSolution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rQueue = new ArrayDeque<>();
        Queue<Integer> dQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();
            if (rIndex < dIndex) {
                rQueue.offer(rIndex + n);
            } else {
                dQueue.offer(dIndex + n);
            }
        }

        return (rQueue.size() > dQueue.size()) ? "Radiant" : "Dire";
    }
}
