package com.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>Palindrome Partitioning</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.</p>
 *
 * <p>A substring is a contiguous non-empty sequence of characters within a string.</p>
 * <p>A palindrome is a string that reads the same forward and backward.</p>
 *
 * @see <a href="https://leetcode.com/problems/palindrome-partitioning/">131. Palindrome Partitioning</a>
 */
public class PalindromePartitioningSolution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        palindromePartition(0, s, new LinkedList<>(), result);
        return result;
    }

    private static void palindromePartition(int index, String s, List<String> part, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                part.add(s.substring(index, i + 1));
                palindromePartition(i + 1, s, part, result);
                removeLastFrom(part);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static void removeLastFrom(List<String> list) {
        list.remove(list.size() - 1);
    }
}
