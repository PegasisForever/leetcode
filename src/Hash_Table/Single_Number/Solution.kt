package Hash_Table.Single_Number

//https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176/
class Solution {
    fun singleNumber(nums: IntArray): Int {
        val set1 = hashSetOf<Int>()
        val set2 = hashSetOf<Int>()

        nums.forEach { num ->
            if (num !in set1) {
                set1 += num
            } else {
                set2 += num
            }
        }

        set1.removeAll(set2)
        return set1.first()
    }
}