package Array_and_String.Add_Binary

import kotlin.math.max

fun main() {
    with(Solution()){
        println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
            "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"))
    }
}

//https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
class Solution {
    fun addBinary(a: String, b: String): String {
        var carry = 0
        val result = CharArray(max(a.length, b.length))
        repeat(result.size) { cursor ->
            val aDigit = if (cursor < a.length) {
                if (a[a.length - 1 - cursor] == '1') 1 else 0
            } else 0
            val bDigit = if (cursor < b.length) {
                if (b[b.length - 1 - cursor] == '1') 1 else 0
            } else 0

            val sum = aDigit + bDigit + carry
            when (sum) {
                0 -> {
                    carry = 0
                    result[result.size - 1 - cursor] = '0'
                }
                1 -> {
                    carry = 0
                    result[result.size - 1 - cursor] = '1'
                }
                2 -> {
                    carry = 1
                    result[result.size - 1 - cursor] = '0'
                }
                3 -> {
                    carry = 1
                    result[result.size - 1 - cursor] = '1'
                }
            }
        }
        return (if (carry == 1) "1" else "") + result.joinToString("")
    }
}