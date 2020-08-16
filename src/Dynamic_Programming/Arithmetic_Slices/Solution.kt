package Dynamic_Programming.Arithmetic_Slices

// https://leetcode.com/problems/arithmetic-slices/solution/
class Solution {
    fun numberOfArithmeticSlices(arr: IntArray): Int {
        val cache = Array(arr.size) { IntArray(arr.size) { Int.MIN_VALUE } }
        var count = 0

        for (i in 0..(arr.lastIndex - 2)) {
            if (arr[i] - arr[i + 1] == arr[i + 1] - arr[i + 2]) {
                cache[i][i + 2] = arr[i + 1] - arr[i]
                count++
            }
        }

        for (space in 3 until arr.size) {
            for (i in 0..(arr.lastIndex - space)) {
                if (cache[i][i + space - 1] == arr[i + space] - arr[i + space - 1]) {
                    cache[i][i + space] = arr[i + space] - arr[i + space - 1]
                    count++
                }
            }
        }

        return count
    }
}
