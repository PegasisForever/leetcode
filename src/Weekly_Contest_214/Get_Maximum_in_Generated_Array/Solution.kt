package a

// https://leetcode.com/problems/get-maximum-in-generated-array/
class Solution {
    fun getMaximumGenerated(n: Int): Int {
        val arr = IntArray(n + 1)
        var max = 0;
        for (i in arr.indices) {
            if (i == 0) {
                arr[i] = 0
            } else if (i == 1) {
                arr[i] = 1
            } else if (i % 2 == 0) {
                arr[i] = arr[i / 2]
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1]
            }
            max = maxOf(max, arr[i])
        }
        return max
    }
}
