package Weekly_Contest_30.b

//https://leetcode.com/contest/leetcode-weekly-contest-30/problems/subarray-sum-equals-k/
class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        //sum,times
        val map = hashMapOf<Int, Int>()
        var count = 0
        var sum = 0
        map[0] = 1

        nums.forEach{ num ->
            sum += num
            count += map[sum - k] ?: 0
            map[sum] = (map[sum] ?: 0) + 1
        }
        return count
    }
}