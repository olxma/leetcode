package com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Zigzag Conversion</b>
 * <p>Level: <i>Medium</i></p>
 * <p>The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)</p>
 *
 * <pre>
 *     P   A   H   N
 *     A P L S I I G
 *     Y   I   R
 * </pre>
 *
 * <p>And then read line by line: "PAHNAPLSIIGYIR"</p>
 * <p>Write the code that will take a string and make this conversion given a number of rows:</p>
 * {@code string convert(string s, int numRows);}
 *
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/">6. Zigzag Conversion</a>
 */
public class ZigzagConversionSolution {
    public String convert(String s, int numRows) {
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int rowCounter = 0;
        boolean down = true;
        int index = 0;
        while (index < s.length()) {
            rows.get(down ? rowCounter++ : rowCounter--).append(s.charAt(index++));
            if (rowCounter == numRows - 1) {
                down = false;
            } else if (rowCounter == 0) {
                down = true;
            } else if (numRows == 1) {
                rowCounter = 0;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
