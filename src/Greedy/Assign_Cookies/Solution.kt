package Greedy.Assign_Cookies

// https://leetcode.com/problems/assign-cookies/
class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var count = 0
        var gI = 0
        var sI = 0

        while (gI < g.size && sI < s.size) {
            if (s[sI] >= g[gI]) {
                count++
                gI++
                sI++
            } else {
                sI++
            }
        }
        return count
    }
}
