package N_ary_Tree.N_ary_Tree_Postorder_Traversal

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

//https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/926/
class Solution {
    fun postorder(root: Node?): List<Int> {
        step(root)
        return list
    }

    val list = arrayListOf<Int>()
    fun step(node: Node?) {
        node ?: return
        node.children.forEach { step(it) }
        list.add(node.`val`)
    }
}