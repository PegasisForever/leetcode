package Greedy.Split_a_String_in_Balanced_Strings

// https://leetcode.com/problems/split-a-string-in-balanced-strings/
class Solution {
    fun balancedStringSplit(s: String): Int {
        var extraL = 0
        var count = 0
        s.forEach { c ->
            if (c == 'R') {
                extraL--
            } else {
                extraL++
            }
            if (extraL == 0) count++
        }
        return count
    }
}
