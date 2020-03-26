package Hash_Table.Contains_Duplicate

//https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112/
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        nums.forEach { num ->
            if (num in set) {
                return true
            }
            set += num
        }
        return false
    }
}