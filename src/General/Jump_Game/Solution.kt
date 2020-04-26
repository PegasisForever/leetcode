package General.Jump_Game

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3310/
class Solution {
    fun canJump(nums: IntArray): Boolean {
        this.nums = nums
        memo = Array<Boolean?>(nums.size) { null }
        return step(0)
    }

    lateinit var nums: IntArray
    lateinit var memo: Array<Boolean?>

    fun step(i: Int): Boolean {
        if (i >= nums.lastIndex) return true
        if (memo[i] != null) return memo[i]!!

        for (length in 1..nums[i]) {
            if (step(i + length)) return true.also { memo[i] = it }
        }
        return false.also { memo[i] = it }
    }
}