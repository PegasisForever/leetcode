package General.Contiguous_Array

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3298/
class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        var count = 0
        var max = 0
        nums.forEachIndexed { i, num ->
            if (count in map.keys) {
                max = maxOf(max, i - map[count]!!)
            } else {
                map[count] = i
            }
            when (num) {
                1 -> count++
                0 -> count--
            }
        }

        if (count in map.keys) {
            max = maxOf(max, nums.size - map[count]!!)
        }
        return max
    }
}