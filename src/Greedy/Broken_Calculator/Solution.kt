package Greedy.Broken_Calculator

// https://leetcode.com/problems/broken-calculator
class Solution {
    fun brokenCalc(x: Int, y: Int): Int {
        if (y < x) return x - y
        if (y == x) return 0

        var y = y
        var count = 0
        while (y != x) {
            if (y % 2 == 0 && y > x) {
                y /= 2
            } else {
                y++
            }
            count++
        }

        return count
    }
}
