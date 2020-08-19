package Greedy.Minimum_Add_to_Make_Parentheses_Valid

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class Solution {
    fun minAddToMakeValid(str: String): Int {
        var extraLeft = 0
        var ans = 0
        str.forEach { c ->
            if (c == '(') {
                extraLeft++
            } else {
                extraLeft--
            }

            if (extraLeft == -1) {
                extraLeft = 0
                ans++
            }
        }
        return ans + extraLeft
    }
}