package Hash_Table.Top_K_Frequent_Elements

import java.util.*
import kotlin.collections.HashMap

//https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val map = HashMap<Int, Int>()
        nums.forEach { num ->
            map[num] = (map[num] ?: 0) + 1
        }

        val heep = PriorityQueue<Int>(Comparator { num1, num2 ->
            map[num1]!! - map[num2]!!
        })
        map.keys.forEach { num ->
            heep.add(num)
            if (heep.size > k) heep.poll()
        }

        return heep.toList().asReversed()
    }
}