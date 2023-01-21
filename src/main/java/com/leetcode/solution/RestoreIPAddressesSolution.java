package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Restore IP Addresses</b>
 * <p>Level: <i>Medium</i></p>
 * <p>A valid IP address consists of exactly four integers separated by single dots.
 * Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.</p>
 *
 * <ul>
 *     <li>For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses,
 *     but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.</li>
 * </ul>
 *
 * <p>Given a string s containing only digits, return all possible valid IP addresses
 * that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s.
 * You may return the valid IP addresses in any order.</p>
 *
 * @see <a href="https://leetcode.com/problems/restore-ip-addresses/">93. Restore IP Addresses</a>
 */
public class RestoreIPAddressesSolution {
    private List<String> result;
    private String s;

    public List<String> restoreIpAddresses(String s) {
        this.result = new ArrayList<>();
        this.s = s;

        findIP("", 0, 0);

        return result;
    }

    private void findIP(String current, int index, int dots) {
        if (dots > 4) return;
        if (dots == 4 && index >= s.length()) {
            result.add(current.substring(0, current.length() - 1));
            return;
        }
        for (int len = 1; (len <= 3 && index + len <= s.length()); len++) {
            String num = s.substring(index, index + len);
            if (num.charAt(0) == '0' && len != 1) break;
            else if (Integer.parseInt(num) <= 255) {
                findIP(current + s.substring(index, index + len) + ".", index + len, dots + 1);
            }
        }
    }
}
