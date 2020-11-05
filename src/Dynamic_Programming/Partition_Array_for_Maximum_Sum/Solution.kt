package Dynamic_Programming.Partition_Array_for_Maximum_Sum

// https://leetcode.com/problems/partition-array-for-maximum-sum/
class Solution {
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        this.arr = arr
        this.k = k
        cache = IntArray(arr.size) { -1 }
        return findMax(0)
    }

    lateinit var arr: IntArray
    var k = 0
    lateinit var cache: IntArray

    fun findMax(index: Int): Int {
        if (index >= arr.size) return 0
        if (cache[index] != -1) return cache[index]
        var curMax = -1
        var maxSum = 0
        var i = index
        while (i < arr.size && i < index + k) {
            curMax = maxOf(curMax, arr[i])
            maxSum = maxOf(maxSum, curMax * (i - index + 1) + findMax(i + 1))
            i++
        }
        cache[index] = maxSum
        return maxSum
    }
}
