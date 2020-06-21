package Binary_Search.Pow_x_n

//https://leetcode.com/explore/learn/card/binary-search/137/conclusion/982/
class Solution {
    private fun fastPow(x: Double, n: Long): Double {
        if (n == 0L) {
            return 1.0
        }
        val half = fastPow(x, n / 2)
        return if (n % 2 == 0L) {
            half * half
        } else {
            half * half * x
        }
    }

    fun myPow(x: Double, n: Int): Double {
        var n = n.toLong()
        var x = x
        if (n < 0) {
            x = 1 / x
            n = -n
        }
        return fastPow(x, n)
    }
}
