package Greedy.Lemonade_Change

// https://leetcode.com/problems/lemonade-change/
class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        var fives = 0
        var tens = 0
        bills.forEach { bill ->
            when (bill) {
                5 -> fives++
                10 -> if (fives >= 1) {
                    fives--
                    tens++
                } else {
                    return false
                }
                20 -> if (tens >= 1 && fives >= 1) {
                    tens--
                    fives--
                } else if (fives >= 3) {
                    fives -= 3
                } else {
                    return false
                }
            }
        }
        return true
    }
}
