package Weekly_Contest_213.Check_Array_Formation_Through_Concatenation

fun main() {
    Solution().canFormArray(intArrayOf(1), arrayOf(intArrayOf()))
}

// https://leetcode.com/contest/weekly-contest-213/problems/check-array-formation-through-concatenation/
class Solution {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val arr = arr.toMutableList()
        try {
            for (piece in pieces) {
                val index = arr.indexOf(piece[0])
                if (index == -1) return false
                repeat(piece.size) {
                    arr.removeAt(index)
                }
            }
        } catch (e: Throwable) {
            return false
        }

        return arr.isEmpty()
    }
}
