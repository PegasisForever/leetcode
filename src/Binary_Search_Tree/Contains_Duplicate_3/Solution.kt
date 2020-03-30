package Binary_Search_Tree.Contains_Duplicate_3

import java.util.*
import kotlin.math.abs
import kotlin.math.min


fun main() {
    Solution2().containsNearbyAlmostDuplicate(intArrayOf(7, 1, 3), 2, 3)
}

//https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1013/
class Solution {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        if (k == 0) return false
        val queue: Queue<Int> = LinkedList()
        repeat(min(k, nums.size - 1)) { i ->
            queue.add(nums[i + 1])
        }

        for (i in nums.indices) {
            if (queue.find { abs(nums[i].toLong() - it) <= t } != null) return true
            queue.poll()
            if (i + k + 1 < nums.size) queue.offer(nums[i + k + 1])
        }
        return false
    }
}

class Solution2 {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        if (k == 0) return false
        val map = TreeMap<Long, Int>()

        repeat(min(k, nums.size - 1)) { i ->
            val key = nums[i + 1].toLong()
            map[key] = (map[key] ?: 0) + 1
        }

        for (i in nums.indices) {
            val n = map.ceilingKey(nums[i].toLong() - t)
            if (n != null && n <= nums[i].toLong() + t) return true


            if (i + 1 < nums.size) with(nums[i + 1].toLong()) {
                if (map[this] == 1) {
                    map.remove(this)
                } else {
                    map[this] = map[this]!! - 1
                }

            }
            if (i + k + 1 < nums.size) with(nums[i + k + 1].toLong()) {
                map[this] = (map[this] ?: 0) + 1
            }
        }
        return false
    }
}