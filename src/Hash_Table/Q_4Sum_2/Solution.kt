package Hash_Table.Q_4Sum_2

//https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1134/
class Solution {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        val map = HashMap<Int, Int>()

        A.forEach { a ->
            B.forEach { b ->
                map[a + b] = (map[a + b] ?: 0) + 1
            }
        }

        var count = 0
        C.forEach { c ->
            D.forEach { d ->
                count += map[-(c + d)] ?: 0
            }
        }

        return count
    }
}