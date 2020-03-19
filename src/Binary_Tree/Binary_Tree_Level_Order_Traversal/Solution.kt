package Binary_Tree.Binary_Tree_Level_Order_Traversal

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/1037/
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        step(root,0)
        return result
    }

    val result = arrayListOf<LinkedList<Int>>()
    fun step(root: TreeNode?, level: Int) {
        if (root == null) return

        //size:0 level:0
        if (result.size == level) {
            result.add(LinkedList<Int>().apply { add(root.`val`) })
        } else {
            result[level].add(root.`val`)
        }

        step(root.left, level + 1)
        step(root.right, level + 1)
    }
}