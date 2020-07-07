package Arrays_101.Valid_Mountain_Array

// https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
class Solution {
    fun validMountainArray(arr: IntArray): Boolean {
        if (arr.size < 3) return false
        var increasing = true
        var lastNum: Int? = null
        arr.forEachIndexed { i, num ->
            if (lastNum != null) {
                if (increasing) {
                    when {
                        num == lastNum -> return false
                        num < lastNum!! -> if (i == 1) {
                            return false
                        } else {
                            increasing = false
                        }
                    }
                } else {
                    when {
                        num == lastNum -> return false
                        num > lastNum!! -> return false
                    }
                }
            }
            lastNum = num
        }

        return !increasing
    }
}
