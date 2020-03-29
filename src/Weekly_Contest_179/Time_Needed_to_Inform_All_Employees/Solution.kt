package Weekly_Contest_179.Time_Needed_to_Inform_All_Employees

import kotlin.math.max

fun main() {
    val s = Solution()
    s.numOfMinutes(
        6, 2,
        intArrayOf(2, 2, -1, 2, 2, 2),
        intArrayOf(0, 0, 1, 0, 0, 0)
    )
}

//https://leetcode.com/contest/weekly-contest-179/problems/time-needed-to-inform-all-employees/
class Solution {
    class Node(val informTime: Int) {
        val listeners = arrayListOf<Node>()
    }

    fun numOfMinutes(n: Int, headID: Int, managers: IntArray, informTimes: IntArray): Int {
        val employees = arrayOfNulls<Node>(n)
        informTimes.forEachIndexed { i, informTime ->
            employees[i] = Node(informTime)
        }

        managers.forEachIndexed { i, manager ->
            if (manager != -1)
                employees[manager]!!.listeners.add(employees[i]!!)
        }
        val root = employees[headID]!!
        return send(root)
    }

    fun send(node: Node): Int {
        var timeMax = 0
        node.listeners.forEach { listener ->
            timeMax = max(timeMax, send(listener))
        }
        return timeMax + node.informTime
    }
}