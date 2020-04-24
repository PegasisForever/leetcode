package Binary_Search.Pow_x_n

import kotlin.math.absoluteValue
import kotlin.math.sqrt

//https://leetcode.com/explore/learn/card/binary-search/137/conclusion/982/
//timeout
class Solution {
    fun primeFactors(n: Long): List<Long> {
        val result = arrayListOf<Long>()
        var n = n
        while (n % 2 == 0L) {
            result += 2
            n /= 2
        }

        var i = 3L
        while (i <= sqrt(n.toDouble())) {
            while (n % i == 0L) {
                result += i
                n /= i
            }
            i += 2
        }

        if (n > 2) result += n
        return result
    }

    fun myPow(x: Double, n: Int): Double {
        if (n == 0 || x == 1.0) return 1.0
        val posN = n.toLong().absoluteValue
        var value = x
        primeFactors(posN).forEach { factor ->
            var newValue = value
            repeat(factor.toInt() - 1) {
                newValue *= value
            }
            value = newValue
        }
        return if (posN > 0) value else (1.0 / value)
    }
}