package com.leetcode.solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <b>Keys and Rooms</b>
 * <p>Level: <i>Medium</i></p>
 *
 * <p>There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.</p>
 *
 * <p>When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
 * denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.</p>
 *
 * <p>Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.</p>
 *
 * @see <a href="https://leetcode.com/problems/keys-and-rooms/">841. Keys and Rooms</a>
 */
public class KeysAndRoomsSolution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int roomCounter = 0;
        Queue<Integer> roomsToVisit = new LinkedList<>();

        roomsToVisit.offer(0);
        while (!roomsToVisit.isEmpty()) {
            int room = roomsToVisit.poll();
            if (!visited[room]) {
                visited[room] = true;
                roomCounter++;

                for (Integer key : rooms.get(room)) {
                    if (!visited[key]) {
                        roomsToVisit.offer(key);
                    }
                }
            }
        }

        return roomCounter == rooms.size();
    }
}
