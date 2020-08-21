package Greedy.Car_Pooling

// https://leetcode.com/problems/car-pooling/
class Solution {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val delta = IntArray(1001)
        trips.forEach { (count, start, end) ->
            delta[start] += count
            delta[end] -= count
        }

        var current = 0
        delta.forEach { d ->
            current += d
            if (current > capacity) return false
        }

        return true
    }
}
