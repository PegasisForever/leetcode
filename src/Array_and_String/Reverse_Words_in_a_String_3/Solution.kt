package Array_and_String.Reverse_Words_in_a_String_3

fun main() {
    Solution().reverseWords("abc efg")
}

//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1165/
class Solution {
    fun reverseWords(s: String): String {
        if (s.isBlank()) return s
        val charArray = s.toCharArray()

        var left: Int? = null
        var right = 0
        while (right < charArray.size) {
            if (!charArray[right].isWhitespace()) {
                if (left == null) left = right
            } else if (left != null) {
                reverse(charArray, left, right - 1)
                left = null
            }
            right++
        }
        if (left != null) reverse(charArray, left, right - 1)


        return charArray.joinToString("")
    }

    fun reverse(array: CharArray, start: Int, end: Int) {
        var i = start
        var j = end
        repeat((j - i + 1) / 2) {
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
            i++
            j--
        }
    }
}