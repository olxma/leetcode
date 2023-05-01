package com.leetcode.solution;

import java.util.Arrays;

/**
 * <b>Average Salary Excluding the Minimum and Maximum Salary</b>
 * <p>Level: <i>Easy</i></p>
 * <p>You are given an array of unique integers salary
 * where salary[i] is the salary of the i<sup>th</sup> employee.</p>
 *
 * <p>Return the average salary of employees excluding the minimum and maximum salary.
 * Answers within 10<sup>-5</sup> of the actual answer will be accepted.</p>
 *
 * @see <a href="https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/">
 * 1491. Average Salary Excluding the Minimum and Maximum Salary</a>
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalarySolution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        int employees = salary.length - 2;
        return sum / employees;
    }
}
