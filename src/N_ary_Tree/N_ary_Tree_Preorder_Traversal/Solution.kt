package N_ary_Tree.N_ary_Tree_Preorder_Traversal

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

//https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/925/
class Solution {
    fun preorder(root: Node?): List<Int> {
        step(root)
        return list
    }

    val list = arrayListOf<Int>()
    fun step(node: Node?) {
        node ?: return
        list.add(node.`val`)
        node.children.forEach { step(it) }
    }
}