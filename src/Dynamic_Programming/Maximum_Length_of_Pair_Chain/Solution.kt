package Dynamic_Programming.Maximum_Length_of_Pair_Chain

import println

fun main() {
    Solution()
        .findLongestChain(
            arrayOf(
                intArrayOf(-2, 4),
                intArrayOf(1, 5),
                intArrayOf(2, 3),
                intArrayOf(-5, -2),
                intArrayOf(-8, 9),
                intArrayOf(-1, 0),
                intArrayOf(-1, 2)
            )
        ).println()
}

// https://leetcode.com/problems/maximum-length-of-pair-chain/
class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        this.pairs = pairs
            .map { it[0] to it[1] }
            .sortedBy { it.first }
        cache = IntArray(pairs.size) { -1 }


        var max = 1
        repeat(pairs.size) { i ->
            max = maxOf(max, step(i))
        }
        return max
    }

    lateinit var cache: IntArray
    lateinit var pairs: List<Pair<Int, Int>>

    fun step(i: Int): Int {
        if (cache[i] != -1) return cache[i]
        val pair = pairs[i]
        val followingI = binaryFindFirst(i + 1, pairs.lastIndex) { j ->
            pairs[j].first > pair.second
        } ?: return 0

        var max = 1
        for (nextI in followingI..pairs.lastIndex) {
            max = maxOf(max, step(nextI) + 1)
        }

        cache[i] = max
        return max
    }

    // from: include  to: include
    inline fun binaryFindFirst(from: Int, to: Int, action: (Int) -> Boolean): Int? {
        var left = from
        var right = to
        var mid: Int
        while (left < right) {
            mid = left + (right - left) / 2
            if (action(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return if (left == to) {
            if (action(to)) {
                to
            } else {
                null
            }
        } else {
            left
        }
    }
}

