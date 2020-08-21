package Greedy.Queue_Reconstruction_by_Height

// https://leetcode.com/problems/queue-reconstruction-by-height/
class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        val p = people
            .sortedWith(Comparator { o1, o2 ->
                if (o1[0] != o2[0]) {
                    o1[0] - o2[0]
                } else {
                    o2[1] - o1[1]
                }
            })
            .asReversed()
            .toMutableList()

        val result = arrayListOf<IntArray>()

        p.forEach { person ->
            result.add(person[1], person)
        }

        return result.toTypedArray()
    }
}
