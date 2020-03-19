package Binary_Tree.Binary_Tree_Inorder_Traversal

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        step(root)
        return list
    }

    val list = LinkedList<Int>()

    fun step(root: TreeNode?) {
        root ?: return

        step(root.left)
        list += root.`val`
        step(root.right)
    }
}