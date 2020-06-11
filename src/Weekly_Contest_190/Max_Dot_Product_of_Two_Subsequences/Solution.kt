package Weekly_Contest_190.Max_Dot_Product_of_Two_Subsequences

//https://leetcode.com/problems/max-dot-product-of-two-subsequences/
class Solution {
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        memo = Array(nums1.size + 1) { IntArray(nums2.size + 1) { Int.MIN_VALUE } }
        val ans = step(nums1.toList(), nums2.toList())
        return if (ans == 0) {
            maxOf(nums1.min()!! * nums2.max()!!, nums1.max()!! * nums2.min()!!)
        } else {
            ans
        }
    }

    lateinit var memo: Array<IntArray>

    fun step(a: List<Int>, b: List<Int>): Int {
        if (a.isEmpty() || b.isEmpty()) return 0
        if (memo[a.size][b.size] != Int.MIN_VALUE) {
            return memo[a.size][b.size]
        }

        val subA = a.subList(1, a.size)
        val subB = b.subList(1, b.size)
        return maxOf(
            step(subA, subB) + a[0] * b[0],
            step(subA, b),
            step(a, subB)
        ).also {
            memo[a.size][b.size] = it
        }
    }
}
