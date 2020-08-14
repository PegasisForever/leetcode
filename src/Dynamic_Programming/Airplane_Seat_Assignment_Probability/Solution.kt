package Dynamic_Programming.Airplane_Seat_Assignment_Probability

// https://leetcode.com/problems/airplane-seat-assignment-probability/submissions/
class Solution {
    fun nthPersonGetsNthSeat(n: Int): Double {
        return if (n == 1) 1.0 else 0.5
    }
}
