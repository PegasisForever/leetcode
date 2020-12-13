package General.Longest_Common_Subsequence

fun main() {
    Solution().longestCommonSubsequence("abc", "def")
}


class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        this.text1 = text1
        this.text2 = text2
        memo = Array(text1.length) { IntArray(text2.length) { -1 } }
        return step(0, 0)
    }

    lateinit var text1: String
    lateinit var text2: String
    lateinit var memo: Array<IntArray>

    fun step(i: Int, j: Int): Int {
        if (i == text1.length || j == text2.length) return 0
        if (memo[i][j] != -1) return memo[i][j]
        return if (text1[i] == text2[j]) {
            step(i + 1, j + 1) + 1
        } else {
            maxOf(step(i + 1, j), step(i, j + 1))
        }.also { memo[i][j] = it }
    }
}


//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3311/
//class Solution {
//    fun longestCommonSubsequence(text1: String, text2: String): Int {
//        this.text1 = text1
//        this.text2 = text2
//        memo = Array(text1.length) { IntArray(text2.length) { -1 } }
//        return step(text1.lastIndex, text2.lastIndex)
//    }
//
//    lateinit var text1: String
//    lateinit var text2: String
//    lateinit var memo: Array<IntArray>
//
//    fun step(i: Int, j: Int): Int {
//        if (i < 0 || j < 0) return 0
//        if (memo[i][j] != -1) return memo[i][j]
//        val result = if (text1[i] == text2[j]) {
//            step(i - 1, j - 1) + 1
//        } else {
//            maxOf(step(i - 1, j), step(i, j - 1))
//        }
//        return result.also { memo[i][j] = it }
//    }
//}
