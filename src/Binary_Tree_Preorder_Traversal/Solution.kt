package Binary_Tree_Preorder_Traversal

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val stack = Stack<TreeNode?>()
        stack.push(root)
        val list = LinkedList<Int>()

        while (stack.isNotEmpty()) {
            val item = stack.pop() ?: continue

            list += item.`val`
            stack.push(item.right)
            stack.push(item.left)
        }
        return list
    }
}

class Solution2 {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        step(root)
        return list
    }


    val list = arrayListOf<Int>()

    fun step(root: TreeNode?) {
        if (root == null) return

        list += root.`val`
        step(root.left)
        step(root.right)
    }
}