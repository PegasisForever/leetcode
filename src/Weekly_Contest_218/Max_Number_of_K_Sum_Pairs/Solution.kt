package Weekly_Contest_218.Max_Number_of_K_Sum_Pairs

import println

fun main() {
    Solution().maxOperations(intArrayOf(3, 1, 3, 4, 3), 6).println()
}

// https://leetcode.com/contest/weekly-contest-218/problems/max-number-of-k-sum-pairs/
class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val map = hashMapOf<Int, Int>()
        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }

        var count = 0
        for (a in map.keys) {
            val b = k - a
            val c = if (a == b) {
                (map[a] ?: 0) / 2
            } else {
                minOf(map[a] ?: 0, map[b] ?: 0)
            }
            if (c > 0) {
                map[a] = map[a]!! - c
                map[b] = map[b]!! - c
                count += c
            }
        }

        return count

    }
}
