package Weekly_Contest_181.Longest_Happy_Prefix

fun main() {
    println(Solution().longestPrefix("a"))
}

//https://leetcode.com/contest/weekly-contest-181/problems/longest-happy-prefix/
//timeout
class Solution {
    fun sameContent(a: ByteArray, b: ByteArray, l: Int): Boolean {
        val startIndex = b.size - l
        for (i in 0 until l) {
            if (a[i] != b[startIndex + i]) return false
        }
        return true
    }

    fun longestPrefix(s: String): String {
        val array = s.toByteArray()

        for (l in s.length - 1 downTo 0) {
            if (sameContent(array, array, l)) {
                return s.substring(0, l)
            }
        }
        error("wtf")
    }
}