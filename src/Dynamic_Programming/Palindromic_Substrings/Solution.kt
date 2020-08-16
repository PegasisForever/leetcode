package Dynamic_Programming.Palindromic_Substrings

// https://leetcode.com/problems/palindromic-substrings/solution/
class Solution {
    fun countSubstrings(s: String): Int {
        cache = Array(s.length) { Array<Boolean?>(s.length) { null } }
        repeat(s.length) { i ->
            cache[i][i] = true
        }
        repeat(s.length - 1) { i ->
            cache[i][i + 1] = s[i] == s[i + 1]
        }
        this.s = s

        repeat(s.length) { i ->
            for (j in (i + 1) until s.length) {
                dp(i, j)
            }
        }

        var count = 0
        cache.forEach {
            it.forEach { b ->
                if (b == true) count++
            }
        }
        return count
    }

    lateinit var cache: Array<Array<Boolean?>>
    lateinit var s: String

    fun dp(i: Int, j: Int): Boolean {
        if (cache[i][j] != null) return cache[i][j]!!

        return (dp(i + 1, j - 1) && s[i] == s[j]).also { cache[i][j] = it }
    }
}
