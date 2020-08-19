package Greedy.Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings

// https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
class Solution {
    fun maxDepthAfterSplit(seq: String): IntArray {
        val result = IntArray(seq.length)

        var aLevel = 0
        var bLevel = 0
        seq.forEachIndexed { i, c ->
            if (c == '(') {
                if (aLevel > bLevel) {
                    // put to b
                    bLevel++
                    result[i] = 1
                } else {
                    // put to a
                    aLevel++
                }
            } else {
                if (aLevel > bLevel) {
                    // put to a
                    aLevel--
                } else {
                    // put to b
                    bLevel--
                    result[i] = 1
                }
            }
        }

        return result
    }
}