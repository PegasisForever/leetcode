package Greedy.Monotone_Increasing_Digits

import println

fun main() {
    Solution().monotoneIncreasingDigits(603253288).println()
}

// https://leetcode.com/problems/monotone-increasing-digits/
class Solution {
    fun monotoneIncreasingDigits(n: Int): Int {
        if (n == 0) return 0

        val digits = arrayListOf<Int>()
        var n = n
        var tens = 10
        while (n != 0) {
            val digit = n % tens
            n -= digit
            digits.add((digit.toLong() * 10 / tens).toInt())
            tens *= 10
        }
        digits.reverse()

        val resultDigits = arrayListOf<Int>()
        var last = digits.first()
        resultDigits.add(last)
        for (i in 1..digits.lastIndex) {
            val curr = digits[i]
            if (curr < last) {
                var sameCount = 0
                for (d in resultDigits.asReversed()) {
                    if (d == last) {
                        sameCount++
                    } else {
                        break
                    }
                }
                repeat(sameCount - 1) {
                    resultDigits.removeAt(resultDigits.lastIndex)
                }

                resultDigits[resultDigits.lastIndex] = last - 1
                repeat(digits.size - resultDigits.size) {
                    resultDigits.add(9)
                }
                break
            } else {
                last = curr
                resultDigits.add(last)
            }
        }


        var result = 0
        tens = 1
        resultDigits.asReversed().forEach { d ->
            result += d * tens
            tens *= 10
        }
        return result
    }
}
