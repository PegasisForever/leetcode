package Greedy.Reduce_Array_Size_to_The_Half

// https://leetcode.com/problems/reduce-array-size-to-the-half/
class Solution {
    fun minSetSize(arr: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        arr.forEach { num ->
            map[num] = (map[num] ?: 0) + 1
        }

        val list = map.toList().sortedByDescending { it.second }

        var count = 0
        var delCount = 0
        for ((_, c) in list) {
            delCount += c
            count++
            if (delCount >= arr.size / 2) break
        }
        return count
    }
}
