package Array_and_String.Rotate_Array

fun main() {
    Solution().rotate(intArrayOf(1, 2, 3, 4, 5, 6), 2)
}

//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/
class Solution {
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isEmpty() || k % nums.size == 0) return

        reverse(nums, 0, nums.lastIndex)
        reverse(nums, k % nums.size, nums.lastIndex)
        reverse(nums, 0, (k % nums.size) - 1)
    }

    fun reverse(array: IntArray, start: Int, end: Int) {
        var i = start
        var j = end
        repeat((j - i + 1) / 2) {
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
            i++
            j--
        }
    }
}