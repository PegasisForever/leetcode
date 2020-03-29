package Binary_Search_Tree.Binary_Search_Tree_Iterator

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/1008/
class BSTIterator(root: TreeNode?) {
    val stack = Stack<TreeNode>()
    var curr: TreeNode? = root

    init {
        updateCurr()
    }

    private fun updateCurr() {
        while (curr != null) {
            stack.push(curr)
            curr = curr!!.left
        }
    }

    fun next(): Int {
        val node = stack.pop()
        val value = node.`val`
        curr = node.right
        updateCurr()
        return value
    }

    fun hasNext() = stack.isNotEmpty()
}