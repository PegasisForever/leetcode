package Weekly_Contest_179.Frog_Position_After_T_Seconds

fun main() {
    println(
        Solution()
            .frogPosition(
                7,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(1, 7),
                    intArrayOf(2, 4),
                    intArrayOf(2, 6),
                    intArrayOf(3, 5)
                ),
                20,
                6
            )
    )
}

//https://leetcode.com/contest/weekly-contest-179/problems/frog-position-after-t-seconds/
class Solution {
    class Node(val value: Int) {
        val connected = arrayListOf<Node>()
    }

    fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
        this.target = target
        this.targetTime = t
        val nodes = Array(n) { i -> Node(i + 1) }
        edges.forEach { edge ->
            val node1 = nodes[edge[0] - 1]
            val node2 = nodes[edge[1] - 1]
            node1.connected.add(node2)
            node2.connected.add(node1)
        }

        step(null, nodes[0], 1.0, 0)
        return prob ?: 0.0
    }

    var targetTime = 0
    var target = 0
    var prob: Double? = null
    fun step(fromNode: Node?, node: Node, prob: Double, time: Int) {
        if (this.prob != null || time > targetTime) return
        if ((node.connected.size - (if (fromNode != null) 1 else 0) == 0 || time == targetTime) && node.value == target) {
            this.prob = prob
            return
        }
        var connectedSize = node.connected.size
        if (fromNode != null) connectedSize--
        node.connected.forEach { nextNode ->
            if (nextNode != fromNode) {
                step(node, nextNode, prob / connectedSize, time + 1)
            }
        }
    }
}