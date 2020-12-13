package General.Edit_Distance

fun main() {
    Solution().minDistance("se","os")
}

// https://leetcode.com/problems/edit-distance/
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        this.word1 = word1
        this.word2 = word2
        cache = Array(word1.length) { IntArray(word2.length) { -1 } }
        return step(0, 0)
    }

    lateinit var word1: String
    lateinit var word2: String
    lateinit var cache: Array<IntArray>

    fun step(i: Int, j: Int): Int {
        if (i == word1.length) return word2.length - j
        if (j == word2.length) return word1.length - i
        if (cache[i][j] != -1) return cache[i][j]

        return if (word1[i] == word2[j]) {
            step(i + 1, j + 1)
        } else {
            minOf(
                step(i + 1, j + 1) + 1,
                step(i + 1, j) + 1,
                step(i, j + 1) + 1
            )
        }.also { cache[i][j] = it }
    }
}
