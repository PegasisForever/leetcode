package Weekly_Contest_215.Minimum_Operations_to_Reduce_X_to_Zero

// https://leetcode.com/contest/weekly-contest-215/problems/minimum-operations-to-reduce-x-to-zero/
class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val target = nums.sum() - x
        if (target == 0) return nums.size

        val map = hashMapOf<Int, Int>()
        map[0] = -1
        var sum = 0
        var res = Int.MIN_VALUE
        for (i in nums.indices) {
            sum += nums[i]
            if (sum - target in map.keys) {
                res = maxOf(res, i - map[sum - target]!!)
            }
            map[sum] = i
        }

        return if (res == Int.MIN_VALUE) {
            -1
        } else {
            nums.size - res
        }
    }
}
