package General.Binary_Tree_Maximum_Path_Sum

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3314/
class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        step(root)
        return if (maxNodeVal < 0 && result == 0) maxNodeVal else result
    }

    var result = Int.MIN_VALUE
    var maxNodeVal = Int.MIN_VALUE

    fun step(node: TreeNode?): Int {
        node ?: return 0
        maxNodeVal = maxOf(maxNodeVal, node.`val`)
        val left = step(node.left)
        val right = step(node.right)
        result = maxOf(result, left + right + node.`val`)
        return maxOf(0, node.`val`, maxOf(left, right) + node.`val`)
    }
}