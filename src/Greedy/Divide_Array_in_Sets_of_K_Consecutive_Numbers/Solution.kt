package Greedy.Divide_Array_in_Sets_of_K_Consecutive_Numbers

// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
class Solution {
    fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
        if (k == 1) return true
        if (nums.size % k != 0) return false

        val list = nums.toMutableList()
        list.sort()

        try {
            while (list.isNotEmpty()) {
                val first = list.first()
                list.removeAt(0)
                for (i in 1 until k){
                    list.removeAt(list.binarySearch(first + i))
                }
            }
        } catch (e: Throwable) {
            return false
        }
        return true
    }
}
