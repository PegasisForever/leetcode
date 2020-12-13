package Weekly_Contest_219.Stone_Game_VII

import println

fun main() {
    Solution().stoneGameVII(intArrayOf(7, 90, 5, 1, 100, 10, 10, 2)).println()
}

// https://leetcode.com/contest/weekly-contest-219/problems/stone-game-vii/
class Solution {
    fun stoneGameVII(stones: IntArray): Int {
        this.stones = stones.asList()
        stonesPrefix = IntArray(stones.size + 1)
        for (i in stones.indices) {
            stonesPrefix[i + 1] = stonesPrefix[i] + stones[i]
        }

        aliceCache = Array(stones.size + 1) { IntArray(stones.size + 1) { Int.MIN_VALUE } }
        bobCache = Array(stones.size + 1) { IntArray(stones.size + 1) { Int.MIN_VALUE } }
        return alice(0, stones.lastIndex)
    }

    lateinit var stones: List<Int>
    lateinit var stonesPrefix: IntArray
    lateinit var aliceCache: Array<IntArray>
    lateinit var bobCache: Array<IntArray>

    fun getSubSum(i: Int, j: Int): Int {
        return stonesPrefix[j + 1] - stonesPrefix[i]
    }

    fun alice(i: Int, j: Int): Int {
        if (j - i == 1) return maxOf(stones[i], stones[j])
        if (aliceCache[i][j] != Int.MIN_VALUE) return aliceCache[i][j]
        return maxOf(
            bob(i + 1, j) + getSubSum(i + 1, j),
            bob(i, j - 1) + getSubSum(i, j - 1)
        ).also { aliceCache[i][j] = it }
    }

    fun bob(i: Int, j: Int): Int {
        if (j - i == 1) return -maxOf(stones[i], stones[j])
        if (bobCache[i][j] != Int.MIN_VALUE) return bobCache[i][j]
        return minOf(
            alice(i + 1, j) - getSubSum(i + 1, j),
            alice(i, j - 1) - getSubSum(i, j - 1)
        ).also { bobCache[i][j] = it }
    }
}
