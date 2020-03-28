package Hash_Table.Longest_Substring_Without_Repeating_Characters

fun main() {
    val data = arrayOf(
        "abcabcbb",
        "bbbbb",
        "pwwkew",
        "aaaaabc",
        "abccccc"
    )
    val solution = Solution()
    for (d in data) {
        println(solution.lengthOfLongestSubstring(d))
    }
}

//https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        val map = hashMapOf<Char, Int>()
        map[s[0]] = 1
        var left = 0
        var right = 0
        var max = 0

        while (true) {
            if (!map.hasRepeating()) {
                max = maxOf(max, right - left + 1)
                right++
                if (right >= s.length) break
                map.addChar(s[right])
            }else{
                map.removeChar(s[left])
                left++
            }
        }

        return max
    }

    fun HashMap<Char, Int>.hasRepeating(): Boolean {
        return this.values.find { it > 1 } != null
    }

    fun HashMap<Char, Int>.addChar(char: Char) {
        this[char] = (this[char] ?: 0) + 1
    }

    fun HashMap<Char, Int>.removeChar(char: Char) {
        this[char] = this[char]!! - 1
    }
}