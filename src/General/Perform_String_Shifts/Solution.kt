package General.Perform_String_Shifts

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/
class Solution {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var totalShift = 0
        shift.forEach { item ->
            when (item[0]) {
                0 -> totalShift -= item[1]
                1 -> totalShift += item[1]
            }
        }

        totalShift %= s.length
        if (totalShift < 0) totalShift += s.length

        val arr = s.toCharArray()
        rotate(arr, totalShift)

        return arr.joinToString("")
    }

    fun rotate(array: CharArray, k: Int) {
        if (array.isEmpty() || k % array.size == 0) return

        reverse(array, 0, array.lastIndex)
        reverse(array, k % array.size, array.lastIndex)
        reverse(array, 0, (k % array.size) - 1)
    }

    fun reverse(array: CharArray, start: Int, end: Int) {
        var i = start
        var j = end
        repeat((j - i + 1) / 2) {
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
            i++
            j--
        }
    }
}