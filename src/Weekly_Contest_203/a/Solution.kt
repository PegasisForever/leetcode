package Weekly_Contest_203.a

// https://leetcode.com/contest/weekly-contest-203/problems/most-visited-sector-in-a-circular-track/
class Solution {
    fun mostVisited(n: Int, rounds: IntArray): List<Int> {
        val start = rounds.first()
        val end = rounds.last()
        if (start == end) {
            return listOf(start)
        } else if (start < end) {
            return (start..end).toList()
        } else {
            return ((1..end) + (start..n)).toList()
        }
    }
}
