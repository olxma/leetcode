package com.leetcode.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DesignBrowserHistorySolutionTest {
    private final String HOMEPAGE = "leetcode.com";
    private final String URL1 = "google.com";
    private final String URL2 = "facebook.com";
    private final String URL3 = "youtube.com";
    private final String URL4 = "linkedin.com";


    @Test
    void testVersionWithTwoLists() {
        DesignBrowserHistorySolution.BrowserHistory browserHistory1 =
                new DesignBrowserHistorySolution.BrowserHistory(HOMEPAGE);
        browserHistory1.visit(URL1);
        browserHistory1.visit(URL2);
        browserHistory1.visit(URL3);
        assertEquals(URL2, browserHistory1.back(1));
        assertEquals(URL1, browserHistory1.back(1));
        assertEquals(URL2, browserHistory1.forward(1));
        browserHistory1.visit(URL4);
        assertEquals(URL4, browserHistory1.forward(2));
        assertEquals(URL1, browserHistory1.back(2));
        assertEquals(HOMEPAGE, browserHistory1.back(7));
    }

    @Test
    void testVersionWithDoubleLinkedCustomList() {
        DesignBrowserHistorySolution.BrowserHistory2 browserHistory2 =
                new DesignBrowserHistorySolution.BrowserHistory2(HOMEPAGE);
        browserHistory2.visit(URL1);
        browserHistory2.visit(URL2);
        browserHistory2.visit(URL3);
        assertEquals(URL2, browserHistory2.back(1));
        assertEquals(URL1, browserHistory2.back(1));
        assertEquals(URL2, browserHistory2.forward(1));
        browserHistory2.visit(URL4);
        assertEquals(URL4, browserHistory2.forward(2));
        assertEquals(URL1, browserHistory2.back(2));
        assertEquals(HOMEPAGE, browserHistory2.back(7));
    }
}