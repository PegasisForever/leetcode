package Hash_Table.Contains_Duplicate_2

//https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1121/
class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (k == 0 || nums.size < 2) return false
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, num ->
            val lastIndex = map[num]
            if (lastIndex == null || index - lastIndex > k) {
                map[num] = index
            } else {
                return true
            }
        }

        return false
    }
}