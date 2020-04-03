package Binary_Search.Sqrt_x

import kotlin.math.min

fun main() {
    Solution().mySqrt(2147483647)
}

//https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
class Solution {
    fun mySqrt(x: Int): Int {
        var left = 0
        var right = min(46340, x)
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid * mid > x) {
                right = mid - 1
            } else if (mid * mid < x) {
                if (mid == 46340) return mid
                if ((mid + 1) * (mid + 1) > x) {
                    return mid
                } else {
                    left = mid + 1
                }
            } else { // ==
                return mid
            }
        }
        error("wtf")
    }
}