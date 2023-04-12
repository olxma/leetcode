package com.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b>Simplify Path</b>
 * <p>Level: <i>Medium</i></p>
 * <p>Given a string path, which is an absolute path (starting with a slash '/') to a file
 * or directory in a Unix-style file system, convert it to the simplified canonical path.</p>
 *
 * <p>In a Unix-style file system, a period '.' refers to the current directory,
 * a double period '..' refers to the directory up a level,
 * and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
 * For this problem, any other format of periods such as '...' are treated as file/directory names.</p>
 *
 * <p>The canonical path should have the following format:</p>
 *
 * <ul>
 *     <li>The path starts with a single slash '/'.</li>
 *     <li>Any two directories are separated by a single slash '/'.</li>
 *     <li>The path does not end with a trailing '/'.</li>
 *     <li>The path only contains the directories on the path from the root directory
 *     to the target file or directory (i.e., no period '.' or double period '..')</li>
 * </ul>
 *
 * <p>Return the simplified canonical path.</p>
 *
 * @see <a href="https://leetcode.com/problems/simplify-path/">71. Simplify Path</a>
 */
public class SimplifyPathSolution {
    public String simplifyPath(String path) {
        String[] split = path.split("/+");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : split) {
            if (s.equals("..")) {
                if (stack.size() > 1) {
                    stack.removeLast();
                }
            } else if (!s.equals(".")) {
                stack.addLast(s);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.removeFirst());
            if (!stack.isEmpty()) {
                builder.append("/");
            }
        }
        return builder.isEmpty() ? "/" : builder.toString();
    }
}
