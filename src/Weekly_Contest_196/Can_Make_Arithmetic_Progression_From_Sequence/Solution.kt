package Weekly_Contest_196.Can_Make_Arithmetic_Progression_From_Sequence

// https://leetcode.com/contest/weekly-contest-196/problems/can-make-arithmetic-progression-from-sequence/
class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        val sorted = arr.sorted();
        val diff = sorted[1] - sorted[0]
        for (i in 1 until sorted.lastIndex) {
            if (sorted[i + 1] - sorted[i] != diff) return false
        }
        return true
    }
}
