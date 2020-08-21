package Greedy.Minimum_Swaps_to_Make_Strings_Equal

// https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
class Solution {
    fun minimumSwap(s1: String, s2: String): Int {
        var toY = 0
        var toX = 0

        repeat(s1.length) { i ->
            if (s1[i] != s2[i]) {
                if (s1[i] == 'x') {
                    toY++
                } else {
                    toX++
                }
            }
        }

        if ((toY + toX) % 2 == 1) return -1

        return toY / 2 + toX / 2 + (toY % 2) * 2
    }
}
