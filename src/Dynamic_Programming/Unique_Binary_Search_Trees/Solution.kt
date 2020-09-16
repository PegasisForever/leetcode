package Dynamic_Programming.Unique_Binary_Search_Trees

// https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    companion object {
        val cache = IntArray(20) { -1 }
            .apply {
                this[0] = 1
                this[1] = 1
                this[2] = 2
            }
    }

    fun numTrees(n: Int): Int {
        if (cache[n] != -1) return cache[n]

        var left = n - 1
        var right = 0
        var count = 0
        while (left >= 0) {
            count += numTrees(left) * numTrees(right)
            left--
            right++
        }

        cache[n] = count
        return count
    }
}
