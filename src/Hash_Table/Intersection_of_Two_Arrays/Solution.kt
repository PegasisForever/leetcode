package Hash_Table.Intersection_of_Two_Arrays

//https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105/
class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        return nums1.intersect(nums2.asList()).toIntArray()
    }
}