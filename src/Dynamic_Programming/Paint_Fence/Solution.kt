package Dynamic_Programming.Paint_Fence

//https://leetcode.com/problems/paint-fence/
class Solution {
    fun numWays(n: Int, k: Int): Int {
        this.k = k
        memo = IntArray((n + 1).coerceAtLeast(3)) { -1 }
        memo[0] = 0
        memo[1] = k
        memo[2] = k * k
        return step(n)
    }

    var k = 0
    lateinit var memo: IntArray

    fun step(n: Int): Int {
        if (memo[n] != -1) return memo[n]

        return ((k - 1) * (step(n - 1) + step(n - 2))).also { memo[n] = it }
    }
}