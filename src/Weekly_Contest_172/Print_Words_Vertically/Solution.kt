package Weekly_Contest_172.b

//https://leetcode.com/contest/weekly-contest-172/problems/print-words-vertically/
class Solution {
    fun printVertically(s: String): List<String> {
        val words = s.split(" ")
        val maxLength = words.map { it.length }.max()!!
        val list = Array(maxLength) { i ->
            CharArray(words.size) { wordI ->
                val word = words[wordI]
                if (i <= word.lastIndex) {
                    word[i]
                } else {
                    ' '
                }
            }
        }

        return list.map { it.joinToString("").trimEnd() }
    }
}