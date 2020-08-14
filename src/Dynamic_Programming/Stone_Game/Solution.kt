package Dynamic_Programming.Stone_Game

// https://leetcode.com/problems/stone-game/
class Solution {
    fun stoneGame(piles: IntArray): Boolean {
        cache = Array(piles.size) { IntArray(piles.size) { Int.MIN_VALUE } }
        this.piles = piles
        return dp(0, piles.lastIndex, true) > 0
    }

    lateinit var cache: Array<IntArray>
    lateinit var piles: IntArray

    fun dp(i: Int, j: Int, isAlex: Boolean): Int {
        if (cache[i][j] != Int.MIN_VALUE) return cache[i][j]
        if (i == j) return if (isAlex) piles[i] else -piles[i]

        return if (isAlex) {
            maxOf(dp(i + 1, j, !isAlex) + piles[i], dp(i, j - 1, !isAlex) + piles[j])
        } else {
            minOf(dp(i + 1, j, !isAlex) - piles[i], dp(i + 1, j, !isAlex) - piles[j])
        }.also { cache[i][j] = it }
    }
}
