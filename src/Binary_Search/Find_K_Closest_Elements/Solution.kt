package Binary_Search.Find_K_Closest_Elements

//https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        if (x < arr.first()) {
            return arr.asList().subList(0, k)
        } else if (x > arr.last()) {
            return arr.asList().subList(arr.size - k, arr.size)
        }


        var xI = arr.binarySearch(x)
        if (xI < 0) xI = -(xI + 1)

        var left = (xI - k).coerceAtLeast(0)
        var right = (xI + k).coerceAtMost(arr.lastIndex)

        while (right - left + 1 > k) {
            val leftNum = arr[left]
            val rightNum = arr[right]
            if (x - leftNum > rightNum - x) {
                left++
            } else {
                right--
            }
        }

        return arr.asList().subList(left, right + 1)
    }
}