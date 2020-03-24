package Array_and_String.Reverse_String

//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
class Solution {
    fun reverseString(s: CharArray) {
        var i = 0
        var j = s.lastIndex
        repeat(s.size / 2) {
            val temp = s[j]
            s[j] = s[i]
            s[i] = temp

            i++
            j--
        }
    }
}