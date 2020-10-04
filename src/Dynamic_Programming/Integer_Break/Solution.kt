package Dynamic_Programming.Integer_Break

// https://leetcode.com/problems/integer-break/
class Solution {
    fun integerBreak(n: Int): Int {
        var max = 0
        for (first in 1..(n / 2)) {
            val second = n - first
            max = maxOf(max, step(first) * step(second))
        }
        return max
    }

    fun step(n: Int): Int {
        if (cache[n] != -1) return cache[n]

        var max = n
        for (first in 1..(n / 2)) {
            val second = n - first
            max = maxOf(max, step(first) * step(second))
        }

        cache[n] = max
        return max
    }

    companion object {
        val cache = IntArray(59) { -1 }.apply {
            this[1] = 1
        }
    }
}
