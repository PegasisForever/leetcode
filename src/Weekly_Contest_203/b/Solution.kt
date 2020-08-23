package Weekly_Contest_203.b

// https://leetcode.com/contest/weekly-contest-203/problems/maximum-number-of-coins-you-can-get/
class Solution {
    fun maxCoins(piles: IntArray): Int {
        piles.sortDescending()
        var max = 0
        repeat(piles.size / 3) { i ->
            max += piles[i * 2 + 1]
        }

        return max
    }
}
