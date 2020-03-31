package N_ary_Tree.N_ary_Tree_Level_Order_Traversal

import java.util.*

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

//https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/915/
class Solution {
    fun levelOrder(root: Node?): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        root ?: return result
        val queue: Queue<Node> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelList = arrayListOf<Int>()
            result.add(levelList)

            repeat(queue.size) {
                val node = queue.poll()
                levelList.add(node.`val`)
                queue.addAll(node.children)
            }
        }

        return result
    }
}