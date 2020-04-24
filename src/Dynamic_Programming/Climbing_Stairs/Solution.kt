package Dynamic_Programming.Climbing_Stairs

//https://leetcode.com/problems/climbing-stairs/submissions/
class Solution {
    var memo: IntArray? = null
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        if (memo == null) memo = IntArray(n + 1) { -1 }
        if (memo!![n] != -1) return memo!![n]
        return (climbStairs(n - 1) + climbStairs(n - 2)).also { memo!![n] = it }
    }
}