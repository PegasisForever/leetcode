package Dynamic_Programming.Counting_Bits

// https://leetcode.com/problems/counting-bits/
class Solution {
    fun countBits(num: Int): IntArray {
        val dp = IntArray(num + 1)
        for (i in 1..num) {
            dp[i] = dp[i / 2] + i % 2
        }
        return dp
    }
}
