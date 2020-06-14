package Weekly_Contest_193.Minimum_Number_of_Days_to_Make_m_Bouquets

import println

fun main() {
    Solution().minDays(intArrayOf(1, 10, 3, 10, 2), 3, 1).println()
}

// https://leetcode.com/contest/weekly-contest-193/problems/minimum-number-of-days-to-make-m-bouquets/
class Solution {
    fun getOpenArray(bloomDay: IntArray, day: Int): BooleanArray {
        return BooleanArray(bloomDay.size) { i ->
            day >= bloomDay[i]
        }
    }

    fun canMake(openArray: BooleanArray, m: Int, k: Int): Boolean {
        var mLeft = m
        var kBuff = 0
        var ii = 0
        while (mLeft > 0 && ii < openArray.size) {
            val isOpen = openArray[ii]
            if (isOpen) {
                kBuff++
                if (kBuff == k) {
                    mLeft--
                    kBuff = 0
                }
            } else {
                kBuff = 0
            }
            ii++
        }
        return mLeft == 0
    }

    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        return binaryFindFirst(0, 1000000000) { day ->
            val openArray = getOpenArray(bloomDay, day)
            canMake(openArray, m, k)
        } ?: -1
    }

    // from: include  to: include
    inline fun binaryFindFirst(from: Int, to: Int, action: (Int) -> Boolean): Int? {
        var left = from
        var right = to
        var mid = 0
        while (left < right) {
            mid = left + (right - left) / 2
            if (action(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return if (left == to) {
            if (action(to)) {
                to
            } else {
                null
            }
        } else {
            left
        }
    }
}
