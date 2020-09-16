package Dynamic_Programming.Longest_Palindromic_Subsequence

// https://leetcode.com/problems/longest-palindromic-subsequence/
class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        str = s
        cache = Array(s.length) { IntArray(s.length) { -1 } }
        return step(0, s.lastIndex)
    }

    lateinit var str: String
    lateinit var cache: Array<IntArray>

    fun step(i: Int, j: Int): Int {
        if (i > j) return 0
        if (i == j) return 1
        if (cache[i][j] != -1) return cache[i][j]
        if (str[i] == str[j]) {
            return (step(i + 1, j - 1) + 2).also { cache[i][j] = it }
        } else {
            return maxOf(step(i + 1, j), step(i, j - 1)).also { cache[i][j] = it }
        }
    }
}
