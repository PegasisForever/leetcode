package Array_and_String.Array_Partition_1

//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1154/
class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var sum = 0
        repeat(nums.size / 2) { i ->
            sum += nums[i * 2]
        }
        return sum
    }
}