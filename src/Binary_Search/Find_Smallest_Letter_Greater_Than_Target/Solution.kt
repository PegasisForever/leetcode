package Binary_Search.Find_Smallest_Letter_Greater_Than_Target

//https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/
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

    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        return letters[binaryFindFirst(0, letters.lastIndex) { i ->
            letters[i] > target
        } ?: 0]
    }
}
