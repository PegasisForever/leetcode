package Greedy.Check_If_a_String_Can_Break_Another_String

// https://leetcode.com/problems/check-if-a-string-can-break-another-string/
class Solution {
    fun checkIfCanBreak(s1: String, s2: String): Boolean {
        return check(s1, s2) || check(s2, s1)
    }

    fun check(s1: String, s2: String): Boolean {
        val s1Map = IntArray(26)
        s1.forEach { c ->
            s1Map[c.toInt() - 97]++
        }

        s2.forEach { c ->
            val start = c.toInt() - 97
            for (i in start until 26) {
                if (s1Map[i] > 0) {
                    s1Map[i]--
                    return@forEach
                }
            }

            return false
        }

        return true
    }
}
