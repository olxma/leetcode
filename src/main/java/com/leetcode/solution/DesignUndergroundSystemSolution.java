package com.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Design Underground System</b>
 * <p>Level: <i>Medium</i></p>
 * <p>An underground railway system is keeping track of customer travel times between different stations.
 * They are using this data to calculate the average time it takes to travel from one station to another.</p>
 *
 * <p>Implement the UndergroundSystem class:</p>
 * <ul>
 *     <li>
 *         void checkIn(int id, string stationName, int t)
 *         <ul>
 *             <li>A customer with a card ID equal to id, checks in at the station stationName at time t.</li>
 *             <li>A customer can only be checked into one place at a time.</li>
 *         </ul>
 *     </li>
 *     <li>
 *         void checkOut(int id, string stationName, int t)
 *         <ul>
 *             <li>A customer with a card ID equal to id, checks out from the station stationName at time t.</li>
 *         </ul>
 *     </li>
 *     <li>
 *         double getAverageTime(string startStation, string endStation)
 *         <ul>
 *             <li>Returns the average time it takes to travel from startStation to endStation.</li>
 *             <li>The average time is computed from all the previous traveling times
 *             from startStation to endStation that happened directly,
 *             meaning a check in at startStation followed by a check out from endStation.</li>
 *             <li>The time it takes to travel from startStation to endStation may be different
 *             from the time it takes to travel from endStation to startStation.</li>
 *             <li>There will be at least one customer that has traveled
 *             from startStation to endStation before getAverageTime is called.</li>
 *         </ul>
 *     </li>
 * </ul>
 *
 * <p>You may assume all calls to the checkIn and checkOut methods are consistent.
 * If a customer checks in at time t<sub>1</sub> then checks out at time t<sub>2</sub>,
 * then t<sub>1</sub> < t<sub>2</sub>. All events happen in chronological order.</p>
 *
 * @see <a href="https://leetcode.com/problems/design-underground-system/">1396. Design Underground System</a>
 */
public class DesignUndergroundSystemSolution {
    private final Map<Integer, Travel> records;
    private final Map<String, Map<String, AvgTime>> avgTimeMap;

    public DesignUndergroundSystemSolution() {
        this.records = new HashMap<>();
        this.avgTimeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        this.records.put(id, new Travel(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Travel travel = this.records.get(id);
        travel.to = stationName;
        travel.end = t;
        Map<String, AvgTime> map = this.avgTimeMap.computeIfAbsent(travel.from, s -> new HashMap<>());
        AvgTime avgTime = map.computeIfAbsent(travel.to, s -> new AvgTime());
        avgTime.add(travel.getTravelTime());
    }

    public double getAverageTime(String startStation, String endStation) {
        AvgTime avgTime = null;
        Map<String, AvgTime> timeMap = avgTimeMap.get(startStation);
        if (timeMap != null) {
            avgTime = timeMap.get(endStation);
        }
        return avgTime != null ? avgTime.avg : 0;
    }

    private static class Travel {
        private final String from;
        private final int start;
        private String to;
        private int end;

        public Travel(String from, int start) {
            this.from = from;
            this.start = start;
        }

        public int getTravelTime() {
            return end != 0 ? end - start : 0;
        }
    }

    private static class AvgTime {
        private int counter;
        private int time;
        private double avg;

        public void add(int newTime) {
            this.time += newTime;
            this.counter++;
            this.avg = (0.0 + time) / counter;
        }
    }
}
