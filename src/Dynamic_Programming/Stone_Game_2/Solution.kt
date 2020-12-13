package Dynamic_Programming.Stone_Game_2

fun main() {
    Solution().stoneGameII(intArrayOf(2, 7, 9))
}

// https://leetcode.com/problems/stone-game-ii/
class Solution {
    fun stoneGameII(piles: IntArray): Int {
        cache = Array(piles.size) { Array(piles.size) { IntArray(2) { Int.MIN_VALUE } } }
        this.piles = piles.asList()
        return dp(0, 1, true)
    }

    // cache[i][M][isAlex]
    lateinit var cache: Array<Array<IntArray>>
    lateinit var piles: List<Int>

    fun dp(i: Int, m: Int, isAlex: Boolean): Int {
        if (i >= piles.size) return 0
        if (cache[i][m][if (isAlex) 1 else 0] != Int.MIN_VALUE) return cache[i][m][if (isAlex) 1 else 0]
        if (i == piles.lastIndex) return if (isAlex) piles.last() else 0

        return if (isAlex) {
            var sum = 0
            var max = 0
            (i until minOf(i + 2 * m, piles.size)).forEach { currI ->
                sum += piles[currI]
                max = max.coerceAtLeast(
                    sum + dp(currI + 1, maxOf(m, currI - i + 1), !isAlex)
                )
            }
            max
        } else {
            var min = Int.MAX_VALUE
            (i until minOf(i + 2 * m, piles.size)).forEach { currI ->
                min = min.coerceAtMost(
                    dp(currI + 1, maxOf(m, currI - i + 1), !isAlex)
                )
            }
            min
        }.also { cache[i][m][if (isAlex) 1 else 0] = it }
    }
}
