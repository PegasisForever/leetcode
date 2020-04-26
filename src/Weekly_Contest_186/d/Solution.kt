package Weekly_Contest_186.d

fun main() {
    Solution().constrainedSubsetSum(intArrayOf(10, 2, -10, 5, 20), 2)
}

//https://leetcode.com/contest/weekly-contest-186/problems/constrained-subset-sum/
//timeout
class Solution {
    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        this.nums = nums
        this.memo = IntArray(nums.size + 1) { -1 }
        this.k = k
        var result = 0
        for (i in -1 until nums.lastIndex) {
            result = maxOf(result, step(i))
        }
        if (result == 0) result = nums.max()!!
        return result
    }

    var k = 0
    lateinit var nums: IntArray
    lateinit var memo: IntArray

    fun step(lastI: Int): Int {
        if (memo[lastI + 1] != -1) return memo[lastI + 1]
        var max = 0
        for (nextI in lastI + 1..lastI + k) {
            if (nextI > nums.lastIndex) break
            max = maxOf(max, step(nextI) + nums[nextI])
        }
        return max.also { memo[lastI + 1] = it }
    }
}