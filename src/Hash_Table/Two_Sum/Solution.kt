package Hash_Table.Two_Sum

//https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1115/
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            if (target - num in map) {
                return intArrayOf(map[target - num]!!, index)
            }
            map[num] = index
        }

        error("wtf")
    }
}