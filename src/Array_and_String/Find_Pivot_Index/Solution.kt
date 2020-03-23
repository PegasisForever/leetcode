package Array_and_String.Find_Pivot_Index

fun main() {
    val data = arrayOf(
        intArrayOf(1, 7, 3, 6, 5, 6),
        intArrayOf(1, 2, 3)
    )
    val solution = Solution()
    for (d in data) {
        println(solution.pivotIndex(d))
    }
}

//https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/
class Solution {
    fun pivotIndex(nums: IntArray): Int {
        if (nums.isEmpty()) return -1

        var sumBefore = 0
        var sumAfter = 0
        for (i in 1..nums.lastIndex) sumAfter += nums[i]

        var pivot = 0
        while (pivot < nums.size) {
            if (sumBefore == sumAfter) return pivot

            sumBefore += nums[pivot]
            if (pivot + 1 == nums.size) {
                sumAfter = 0
            } else {
                sumAfter -= nums[pivot + 1]
            }

            pivot++
        }
        return -1
    }
}