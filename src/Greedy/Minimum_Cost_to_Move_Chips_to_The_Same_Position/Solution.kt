package Greedy.Minimum_Cost_to_Move_Chips_to_The_Same_Position

// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
class Solution {
    fun minCostToMoveChips(position: IntArray): Int {
        val odd = position.count { it % 2 == 1 }
        val even = position.size - odd

        return if (odd > even) {
            even
        } else {
            odd
        }
    }
}
