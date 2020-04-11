package General.Diameter_of_Binary_Tree

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        step(root)
        return maxDiameter
    }

    var maxDiameter = 0

    //return max depth
    fun step(node: TreeNode?): Int {
        node ?: return 0

        val leftDepth = step(node.left)
        val rightDepth = step(node.right)

        maxDiameter = max(maxDiameter, leftDepth + rightDepth)
        return max(leftDepth, rightDepth) + 1
    }
}