package Binary_Search.Find_Peak_Element

class Solution {
    // from: include  to: include
    inline fun binaryFindFirst(from: Int, to: Int, action: (Int) -> Boolean): Int? {
        var left = from
        var right = to
        var mid: Int
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


    fun findPeakElement(nums: IntArray): Int {
        return binaryFindFirst(0,nums.lastIndex){i->
            if (i == nums.lastIndex) true else nums[i] > nums[i + 1]
        }!!
    }
}
