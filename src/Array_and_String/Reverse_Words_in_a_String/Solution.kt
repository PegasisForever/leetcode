package Array_and_String.Reverse_Words_in_a_String

//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1164/
class Solution {
    fun reverseWords(s: String): String {
        val sb = StringBuilder()

        val charArray = s.toCharArray()
        var left = s.lastIndex
        var right: Int? = null

        while (left >= 0) {
            if (!s[left].isWhitespace()) {
                if (right == null) right = left
            } else if (right != null) {
                sb.append(charArray.copyOfRange(left, right)).append(" ")
                right = null
            }
            left--
        }
        if (right != null) sb.append(charArray.copyOfRange(left, right))

        return sb.toString().trim()
    }
}