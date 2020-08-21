package Greedy.Construct_K_Palindrome_Strings

// https://leetcode.com/problems/construct-k-palindrome-strings/
class Solution {
    fun canConstruct(s: String, k: Int): Boolean {
        if (k > s.length) return false
        if (k == s.length) return true

        val map = IntArray(26)
        s.forEach { c ->
            map[c.toInt() - 97]++
        }

        val minK = map.count { it % 2 == 1 }
        if (k < minK) return false

        val maxK = map.map { it / 2 * 2 }.sum() + minK
        return k <= maxK
    }
}
