package Binary_Search_Tree.Balanced_Binary_Tree

import kotlin.math.abs
import kotlin.math.max

fun main() {
    val data = arrayOf(
        TreeNode(3).apply {
            left = TreeNode(9)
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
    )
    val solution = Solution()
    for (d in data) {
        println(solution.isBalanced(d))
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1027/
class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        step(root)
        return !isNotBalanced
    }

    var isNotBalanced = false

    fun step(node: TreeNode?): Int {
        if (isNotBalanced || node == null) return 0

        val left = step(node.left)
        val right = step(node.right)
        if (abs(left - right) > 1) {
            isNotBalanced = true
        }
        return max(left, right) + 1
    }
}