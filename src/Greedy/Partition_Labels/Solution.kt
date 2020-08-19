package Greedy.Partition_Labels

fun main() {
    Solution().partitionLabels("ababc")
}

// https://leetcode.com/problems/partition-labels/
class Solution {
    fun partitionLabels(str: String): List<Int> {
        val completeCharMap = IntArray(26)
        str.forEach { c ->
            completeCharMap[c.toInt() - 97]++
        }

        val result = ArrayList<Int>()

        val charMap = IntArray(26)
        var count = 0
        str.forEachIndexed { i, c ->
            charMap[c.toInt() - 97]++
            count++
            for (cI in 0..25) {
                if (0 != charMap[cI] && completeCharMap[cI] != charMap[cI]) {
                    return@forEachIndexed
                }
            }
            result.add(count)
            count = 0
        }

        return result

    }
}