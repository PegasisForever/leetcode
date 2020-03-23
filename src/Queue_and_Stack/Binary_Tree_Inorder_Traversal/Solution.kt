package Queue_and_Stack.Binary_Tree_Inorder_Traversal

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val data = arrayOf(
        TreeNode(1).apply {
            right = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }
    )
    val solution = Solution()
    for (d in data) {
        println(solution.inorderTraversal(d))
    }
}

//https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1383/
class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()
        val stack = Stack<TreeNode>()
        var curr = root
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            curr = stack.pop()
            list.add(curr.`val`)
            curr = curr.right
        }
        return list
    }
}