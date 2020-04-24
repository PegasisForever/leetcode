package Dynamic_Programming.Range_Sum_Query_Immutable

//https://leetcode.com/problems/range-sum-query-immutable/
class NumArray(val nums: IntArray) {
    val memo = hashMapOf<Pair<Int, Int>, Int>()

    fun sumRange(i: Int, j: Int): Int {
        if (i == j) return nums[i]
        if (i + 1 == j) return nums[i] + nums[j]
        val pair = i to j
        if (pair in memo) return memo[pair]!!

        return (sumRange(i, i + (j - i) / 2) + sumRange(i + (j - i) / 2 + 1, j)).also { memo[pair] = it }
    }
}