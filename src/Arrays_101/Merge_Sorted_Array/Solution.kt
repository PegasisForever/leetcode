package Arrays_101.Merge_Sorted_Array

// https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i1 = 0
        var i2 = 0
        val newArr = ArrayList<Int>(m + n)

        while (i1 < m && i2 < n) {
            val num1 = nums1[i1]
            val num2 = nums2[i2]
            if (num1 < num2) {
                newArr.add(num1)
                i1++
            } else {
                newArr.add(num2)
                i2++
            }
        }

        while (i1 < m) {
            newArr.add(nums1[i1])
            i1++
        }
        while (i2 < n) {
            newArr.add(nums2[i2])
            i2++
        }

        for (i in nums1.indices) {
            nums1[i] = newArr[i]
        }
    }
}
