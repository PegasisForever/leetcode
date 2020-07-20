package Weekly_Contest_198.Water_Bottles

// https://leetcode.com/contest/weekly-contest-198/problems/water-bottles/
class Solution {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var full = numBottles
        var empty = 0
        var count = 0
        while (full > 0) {
            count += full
            empty += full

            full = empty / numExchange
            empty %= numExchange
        }

        return count
    }
}
