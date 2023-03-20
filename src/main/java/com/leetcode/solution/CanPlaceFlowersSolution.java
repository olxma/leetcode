package com.leetcode.solution;

/**
 * <b>Can Place Flowers</b>
 * <p>Level: <i>Easy</i></p>
 * <p>You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.</p>
 *
 * <p>Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
 * and an integer n, return if n new flowers can be planted
 * in the flowerbed without violating the no-adjacent-flowers rule.</p>
 *
 * @see <a href="https://leetcode.com/problems/can-place-flowers/description/">605. Can Place Flowers</a>
 */
public class CanPlaceFlowersSolution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return checkArray(flowerbed, 0, n);
    }

    private static boolean checkArray(int[] arr, int from, int n) {
        if (n == 0) return true;
        if (from >= arr.length && n > 0) return false;
        if (canBePlantedAt(from, arr)) {
            arr[from] = 1;
            return checkArray(arr, from + 2, n - 1);
        }
        return checkArray(arr, from + 1, n);
    }

    private static boolean canBePlantedAt(int index, int[] arr) {
        return arr[index] == 0 && arr[Math.max(0, index - 1)] == 0 && arr[Math.min(arr.length - 1, index + 1)] == 0;
    }
}
