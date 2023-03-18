package com.leetcode.solution;

import java.util.*;

/**
 * <b>Design Browser History</b>
 * <p>Level: <i>Medium</i></p>
 * <p>You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number of steps or move forward in the history number of steps.</p>
 *
 * <p>Implement the BrowserHistory class:</p>
 *
 * <ul>
 *     <li>BrowserHistory(string homepage) Initializes the object with the homepage of the browser.</li>
 *     <li>void visit(string url) Visits url from the current page. It clears up all the forward history.</li>
 *     <li>string back(int steps) Move steps back in history.
 *     If you can only return x steps in the history and steps > x, you will return only x steps.
 *     Return the current url after moving back in history at most steps.</li>
 *     <li>string forward(int steps) Move steps forward in history.
 *     If you can only forward x steps in the history and steps > x, you will forward only x steps.
 *     Return the current url after forwarding in history at most steps.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/design-browser-history/">1472. Design Browser History</a>
 */
public class DesignBrowserHistorySolution {
    private DesignBrowserHistorySolution() {}

    static class BrowserHistory {
        private final LinkedList<String> bHistory = new LinkedList<>();
        private final LinkedList<String> fHistory = new LinkedList<>();

        public BrowserHistory(String homepage) {
            bHistory.add(homepage);
        }

        public void visit(String url) {
            bHistory.add(url);
            fHistory.clear();
        }

        public String back(int steps) {
            while (steps-- > 0) {
                if (bHistory.size() == 1) break;
                fHistory.addFirst(bHistory.removeLast());
            }
            return bHistory.peekLast();
        }

        public String forward(int steps) {
            while (steps-- > 0) {
                if (fHistory.isEmpty()) break;
                bHistory.add(fHistory.removeFirst());
            }
            return bHistory.peekLast();
        }
    }

    static class BrowserHistory2 {
        private Page current;

        public BrowserHistory2(String homepage) {
            current = new Page(homepage, null);
        }

        public void visit(String url) {
            current.next = new Page(url, current);
            current = current.next;
        }

        public String back(int steps) {
            while (steps-- > 0) {
                if (current.prev == null) break;
                current = current.prev;
            }
            return current.url;
        }

        public String forward(int steps) {
            while (steps-- > 0) {
                if (current.next == null) break;
                current = current.next;
            }
            return current.url;
        }

        private static class Page {
            private final String url;
            private final Page prev;
            private Page next;

            public Page(String url, Page prev) {
                this.url = url;
                this.prev = prev;
            }
        }
    }
}
