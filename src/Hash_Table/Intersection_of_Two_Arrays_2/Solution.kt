package Hash_Table.Intersection_of_Two_Arrays_2

import kotlin.math.min

//https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1178/
class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map1 = hashMapOf<Int, Int>()
        nums1.forEach { num ->
            map1[num] = (map1[num] ?: 0) + 1
        }
        val map2 = hashMapOf<Int, Int>()
        nums2.forEach { num ->
            map2[num] = (map2[num] ?: 0) + 1
        }

        val intersection = map1.keys.intersect(map2.keys)
        val list = arrayListOf<Int>()
        intersection.forEach { num ->
            repeat(min(map1[num]!!, map2[num]!!)) {
                list.add(num)
            }
        }

        return list.toIntArray()
    }
}