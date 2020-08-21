package Greedy.Reorganize_String

import java.lang.StringBuilder
import java.util.*

fun main() {
    Solution().reorganizeString("abbbccccc")
}

// https://leetcode.com/problems/reorganize-string/
class Solution {
    data class MutPair<A, B>(var first: A, var second: B)

    fun reorganizeString(str: String): String {
        val sb = StringBuilder()
        val map = IntArray(26)
        str.forEach { c ->
            map[c.toInt() - 97]++
        }

        // char to count
        val pq = PriorityQueue<MutPair<Int, Int>>(26) { a, b ->
            b.second - a.second
        }
        map.forEachIndexed { char, count ->
            if (count != 0) {
                pq.offer(MutPair(char, count))
            }
        }

        try {
            var lastChar: Int? = null
            while (pq.isNotEmpty()) {
                val temp0 = pq.poll()
                if (temp0.first != lastChar) {
                    sb.append((temp0.first + 97).toChar())

                    lastChar = temp0.first
                    temp0.second--
                    if (temp0.second != 0) pq.offer(temp0)
                } else {
                    val temp1 = pq.poll()
                    sb.append((temp1.first + 97).toChar())

                    lastChar = temp1.first
                    temp1.second--
                    if (temp1.second != 0) pq.offer(temp1)
                    pq.offer(temp0)
                }
            }
            return sb.toString()
        } catch (e: Throwable) {
            return ""
        }
    }
}
