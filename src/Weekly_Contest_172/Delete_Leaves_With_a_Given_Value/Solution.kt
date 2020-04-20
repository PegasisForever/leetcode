package Weekly_Contest_172.c

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/contest/weekly-contest-172/problems/delete-leaves-with-a-given-value/
class Solution {
    var target = 0

    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        this.target = target
        return if (step(root)) null else root
    }

    fun step(node: TreeNode?): Boolean {
        node ?: return true

        val noLeft = step(node.left).apply { if (this) node.left = null }
        val noRight = step(node.right).apply { if (this) node.right = null }

        return noLeft && noRight && node.`val` == target
    }
}