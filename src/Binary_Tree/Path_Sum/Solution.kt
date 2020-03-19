package Binary_Tree.Path_Sum

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
class Solution {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        targetSum = sum
        step(root, 0)
        return hasPath
    }

    var hasPath = false
    var targetSum = 0

    fun step(root: TreeNode?, sum: Int) {
        if (root == null || hasPath) return
        if (root.isLeaf()) if (sum + root.`val` == targetSum) {
            hasPath = true
            return
        }

        step(root.left, sum + root.`val`)
        step(root.right, sum + root.`val`)
    }

    fun TreeNode.isLeaf() = left == null && right == null
}