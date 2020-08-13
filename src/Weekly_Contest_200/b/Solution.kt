package Weekly_Contest_200.b

import java.util.*

class Solution {
    fun getWinner(arr: IntArray, k: Int): Int {
        val linkedList = LinkedList<Int>()
        linkedList.addAll(arr.asList())

        var largest = Int.MIN_VALUE
        var count = 0
        var first: Int
        var second: Int
        repeat(arr.size) {
            first = linkedList[0]
            second = linkedList[1]
            if (first > second) {
                count++
                linkedList.removeAt(1)
                linkedList.add(second)
                if (count == k) return first
                if (first > largest) largest = first
            } else {
                count = 1
                linkedList.removeAt(0)
                linkedList.add(first)
                if (count == k) return second
                if (second > largest) largest = second
            }
        }
        return largest
    }
}
