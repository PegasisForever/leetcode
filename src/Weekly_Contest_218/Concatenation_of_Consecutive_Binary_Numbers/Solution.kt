package Weekly_Contest_218.Concatenation_of_Consecutive_Binary_Numbers

import println

// https://leetcode.com/contest/weekly-contest-218/problems/concatenation-of-consecutive-binary-numbers/
fun main() {
    Solution().concatenatedBinary(100).println()
}

class Solution {
    fun concatenatedBinary(n: Int): Int {
        var result = 0L
        var shift = 0L
        val mod = 1000000007L
        for (i in (1L..n.toLong()).reversed()) {
            val digits = i.binDigits()
            result = ((i * bigMod(2L, shift, mod)) % mod + result) % mod
            shift += digits
        }

        return (result % 1000000007).toInt()
    }

    inline fun square(x: Long) = x * x

    // return b^p % m
    fun bigMod(b: Long, p: Long, m: Long): Long {
        return when {
            p == 0L -> 1
            p % 2 == 0L -> square(bigMod(b, p / 2, m)) % m
            else -> ((b % m) * bigMod(b, p - 1, m)) % m
        }
    }

    val binDigitsMap =
        intArrayOf(0, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072)

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

    fun Long.binDigits() = binaryFindFirst(1, binDigitsMap.lastIndex) { i ->
        val num = binDigitsMap[i]
        return@binaryFindFirst num > this
    }!!
}
