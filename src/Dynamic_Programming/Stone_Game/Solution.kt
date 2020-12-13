package Dynamic_Programming.Stone_Game

// https://leetcode.com/problems/stone-game/
class Solution {
    fun stoneGame(piles: IntArray): Boolean {
        cache = Array(piles.size) { IntArray(piles.size) { Int.MIN_VALUE } }
        this.stones = piles
        return dp(0, piles.lastIndex, true) > 0
    }

    lateinit var cache: Array<IntArray>
    lateinit var stones: IntArray

    fun dp(i: Int, j: Int, isAlex: Boolean): Int {
        if (cache[i][j] != Int.MIN_VALUE) return cache[i][j]
        if (i == j) return if (isAlex) stones[i] else -stones[i]

        return if (isAlex) {
            maxOf(dp(i + 1, j, !isAlex) + stones[i], dp(i, j - 1, !isAlex) + stones[j])
        } else {
            minOf(dp(i + 1, j, !isAlex) - stones[i], dp(i, j - 1, !isAlex) - stones[j])
        }.also { cache[i][j] = it }
    }
}
