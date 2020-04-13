package General.Last_Stone_Weight

import java.util.*

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3297/
class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int> { a, b ->
            -a.compareTo(b)
        }

        heap.addAll(stones.asList())

        while (true) {
            val a = heap.poll() ?: return 0
            val b = heap.poll() ?: return a

            if (a > b) {
                heap.add(a - b)
            }
        }
    }
}