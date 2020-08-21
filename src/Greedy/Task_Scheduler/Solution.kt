package Greedy.Task_Scheduler

import java.util.*

fun main() {
    Solution().leastInterval(charArrayOf('b', 'b', 'b', 'a', 'a', 'c'), 0)
}

// https://leetcode.com/problems/task-scheduler/
class Solution {
    data class MutPair(var char: Int, var count: Int)

    fun leastInterval(tasks: CharArray, n: Int): Int {
        val map = IntArray(26)
        tasks.forEach { c ->
            map[c.toInt() - 65]++
        }

        val list = LinkedList<MutPair>()
        map.forEachIndexed { index, count ->
            if (count != 0) {
                list += MutPair(index, count)
            }
        }
        list.sortByDescending { it.count }


        var time = 0
        val lastRunMap = IntArray(26) { -1000000 }
        while (list.isNotEmpty()) {
            val iter = list.listIterator()
            while (iter.hasNext()) {
                val item = iter.next()
                val char = item.char
                if (time - lastRunMap[char] >= n) {
                    item.count--
                    lastRunMap[char] = time + 1

                    if (item.count == 0) {
                        iter.remove()
                    } else {
                        list.sortByDescending { it.count }
                    }
                    break
                }
            }
            time++
        }

        return time
    }
}

