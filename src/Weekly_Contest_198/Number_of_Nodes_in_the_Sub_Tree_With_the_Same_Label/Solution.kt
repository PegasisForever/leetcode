package Weekly_Contest_198.Number_of_Nodes_in_the_Sub_Tree_With_the_Same_Label

fun main() {
    Solution().countSubTrees(
        2, arrayOf(
            intArrayOf(0, 1)
        ), "ab"
    )
}

// https://leetcode.com/contest/weekly-contest-198/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
class Solution {
    class Node(
        val i: Int,
        val char: Char,
        var children: HashSet<Node> = hashSetOf(),
        val map: IntArray = IntArray(26)
    )

    fun addArray(a: IntArray, b: IntArray) {
        repeat(26) { i ->
            a[i] += b[i]
        }
    }

    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val nodes = Array(n) { i ->
            Node(i, labels[i])
        }

        edges.forEach { edge ->
            nodes[edge[0]].children.add(nodes[edge[1]])
            nodes[edge[1]].children.add(nodes[edge[0]])
        }

        nodes[0].step()

        return nodes.map { it.map[it.char.toInt()-97] }.toIntArray()
    }

    fun Node.step(parent: Node? = null) {
        if (parent != null) children.remove(parent)
        this.map[this.char.toInt() - 97] = 1
        children.forEach { child ->
            child.step(this)
            addArray(this.map, child.map)
        }
    }
}
