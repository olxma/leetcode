package com.leetcode.solution;

/**
 * <b>Jump Game</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.</p>
 *
 * <p>Return true if you can reach the last index, or false otherwise.</p>
 *
 * @see <a href="https://leetcode.com/problems/jump-game/">55. Jump Game</a>
 */
public class JumpGameSolution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int last = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last <= 0;
    }
}
