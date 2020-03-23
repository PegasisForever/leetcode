package Array_and_String.Plus_One

fun main() {
    val data = arrayOf(
        intArrayOf(4, 9, 9),
        intArrayOf(9, 9, 9)
    )
    val solution = Solution()
    for (d in data) {
        println(solution.plusOne(d).joinToString())
    }
}

//https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        digits[digits.lastIndex]++

        var cursor = digits.lastIndex
        var leadingOne = false
        while (cursor >= 0) {
            if (digits[cursor] == 10) {
                digits[cursor] = 0
                if (cursor != 0) {
                    digits[cursor - 1]++
                } else {
                    leadingOne = true
                }
            } else {
                break
            }
            cursor--
        }
        return if (leadingOne) {
            intArrayOf(1, *digits)
        } else {
            digits
        }
    }
}