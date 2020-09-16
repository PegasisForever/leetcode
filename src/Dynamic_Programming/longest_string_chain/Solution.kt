package Dynamic_Programming.longest_string_chain

import println

fun main() {
    Solution().longestStrChain(
        arrayOf("a", "b", "ba", "bca", "bda", "bdca")
    ).println()
}

// https://leetcode.com/problems/longest-string-chain/
class Solution {
    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        this.words = words
        var max = 0
        repeat(words.size) { i ->
            max = max.coerceAtLeast(longestFrom(i) + 1)
        }
        return max
    }

    lateinit var words: Array<String>
    val cache = IntArray(1001) { -1 }

    fun longestFrom(i: Int): Int {
        if (cache[i] != -1) return cache[i]
        val curr = words[i]
        var max = 0
        for (j in (i + 1)..words.lastIndex) {
            if (curr.isPreOf(words[j])) {
                max = max.coerceAtLeast(longestFrom(j) + 1)
            }
        }
        cache[i] = max
        return max
    }

    fun String.isPreOf(other: String): Boolean {
        if (this.length != other.length - 1) return false
        var i = 0
        var j = 0
        var skipped = false
        while (i < this.length) {
            if (this[i] == other[j]) {
                i++
                j++
            } else if (!skipped) {
                j++
                skipped = true
            } else {
                return false
            }
        }
        return true
    }
}
