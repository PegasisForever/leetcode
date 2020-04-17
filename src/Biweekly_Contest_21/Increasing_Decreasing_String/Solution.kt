package Biweekly_Contest_21.a

fun main() {
    Solution().sortString("aaaabbbbcccc")
}

//https://leetcode.com/contest/biweekly-contest-21/problems/increasing-decreasing-string/
class Solution {
    fun sortString(s: String): String {
        val sb = StringBuilder()
        val charList = s.toCharArray().asList().toMutableList()

        while (charList.isNotEmpty()) {
            var min: Char? = Char.MIN_VALUE
            while (charList.filter { it > min!! }.min().also { min = it } != null) {
                charList.remove(min)
                sb.append(min)
            }

            var max: Char? = Char.MAX_VALUE
            while (charList.filter { it < max!! }.max().also { max = it } != null) {
                charList.remove(max)
                sb.append(max)
            }
        }

        return sb.toString()
    }
}