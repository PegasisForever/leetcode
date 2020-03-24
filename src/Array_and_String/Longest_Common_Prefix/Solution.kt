package Array_and_String.Longest_Common_Prefix

import kotlin.math.min

fun main() {
    val data = arrayOf(
        arrayOf("flower", "flow", "flight"),
        arrayOf("abc", "abc", "abc")
    )
    val solution = Solution()
    for (d in data) {
        println(solution.longestCommonPrefix(d))
    }
}

//https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var maxLength = Int.MAX_VALUE
        strs.forEach { str -> maxLength = min(maxLength, str.length) }
        if (maxLength == 0 || strs.isEmpty()) return ""

        repeat(maxLength) { cursor ->
            var char: Char? = null
            strs.forEach { str ->
                if (char == null) {
                    char = str[cursor]
                } else if (str[cursor] != char) {
                    return str.substring(0, cursor)
                }
            }
        }

        return strs[0].substring(0, maxLength)
    }
}