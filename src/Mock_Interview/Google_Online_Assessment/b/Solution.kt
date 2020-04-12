package interview.b

import kotlin.math.max
import kotlin.math.min

//Incorrect
class Solution {
    inner class Node {
        val connected = HashMap<Node, Int>()
        var received = false

        var receivedMinTime = Int.MAX_VALUE

        fun send(time: Int) {
            receivedMinTime = min(receivedMinTime, time)
            if (received) return
            received = true
            receivedNodesCount++
            connected.forEach { (node, latency) ->
                node.send(time + latency)
            }
        }
    }

    var receivedNodesCount = 0

    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val nodes = Array(N) { Node() }

        times.forEach { edge ->
            nodes[edge[0] - 1].connected[nodes[edge[1] - 1]] = edge[2]
        }

        nodes[K - 1].send(0)

        var receivedMaxTime = 0
        nodes.forEach { node -> receivedMaxTime = max(receivedMaxTime, node.receivedMinTime) }

        return if (receivedNodesCount < N) -1 else receivedMaxTime
    }
}