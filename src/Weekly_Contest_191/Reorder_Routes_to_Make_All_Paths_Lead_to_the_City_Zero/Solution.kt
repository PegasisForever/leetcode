package Weekly_Contest_191.Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero

import java.util.*

fun main() {
    Solution().minReorder(
        6, arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(4, 0),
            intArrayOf(4, 5)
        )
    )
}

// https://leetcode.com/contest/weekly-contest-191/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
class Solution {
    class Node(val value: Int) {
        var pointsTo = hashSetOf<Node>()
        var bePointed = hashSetOf<Node>()
        var newPointsTo: Node? = null
    }

    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val nodes = Array(n) { Node(n) }
        connections.forEach { arr ->
            nodes[arr[0]].pointsTo.add(nodes[arr[1]])
            nodes[arr[1]].bePointed.add(nodes[arr[0]])
        }

        var count = 0
        val queue: Queue<Node> = LinkedList<Node>()
        queue.add(nodes[0])
        val visited = hashSetOf<Node>()
        visited.add(nodes[0])

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val thisNode = queue.poll()!!
                thisNode.pointsTo.forEach { node ->
                    if (node in visited) return@forEach
                    node.newPointsTo = thisNode
                    queue += node
                    visited += node
                }
                thisNode.bePointed.forEach { node ->
                    if (node in visited) return@forEach
                    node.newPointsTo = thisNode
                    queue += node
                    visited += node
                }
            }
        }

        return nodes.count { it.newPointsTo !in it.pointsTo } - 1
    }
}
