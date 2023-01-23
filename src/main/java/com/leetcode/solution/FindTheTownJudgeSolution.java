package com.leetcode.solution;

/**
 * <b>Find the Town Judge</b>
 * <p>Level: <i>Easy</i></p>
 * <p>In a town, there are n people labeled from 1 to n.
 * There is a rumor that one of these people is secretly the town judge.</p>
 *
 * <p>If the town judge exists, then:</p>
 * <p>The town judge trusts nobody.</p>
 * <p>Everybody (except for the town judge) trusts the town judge.</p>
 * <p>There is exactly one person that satisfies properties 1 and 2.</p>
 * <p>You are given an array trust where trust[i] = [a<sub>i</sub>, b<sub>i</sub>] representing
 * that the person labeled a<sub>i</sub> trusts the person labeled b<sub>i</sub>.</p>
 *
 * <p>Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.</p>
 *
 * @see <a href="https://leetcode.com/problems/find-the-town-judge/">997. Find the Town Judge</a>
 */
public class FindTheTownJudgeSolution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;

        int[] count = new int[n + 1];
        for (int[] rel : trust) {
            count[rel[0]]--;
            count[rel[1]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == n - 1) return i;
        }

        return -1;
    }
}
