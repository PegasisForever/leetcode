package Binary_Search_Tree.Lowest_Common_Ancestor_of_a_Binary_Search_Tree

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1012/
class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (p == null || q == null || root == null) return root
        if (p.`val` < q.`val`) {
            this.p = p
            this.q = q
        } else {
            this.p = q
            this.q = p
        }

        step(root)
        return ancestor
    }

    lateinit var p: TreeNode
    lateinit var q: TreeNode
    var ancestor: TreeNode? = null

    operator fun Pair<Boolean, Boolean>.plus(other: Pair<Boolean, Boolean>): Pair<Boolean, Boolean> {
        return (first || other.first) to (second || other.second)
    }

    fun step(node: TreeNode): Pair<Boolean, Boolean> {
        if (ancestor != null) return false to false

        val leftResult = if (node.`val` > p.`val` && node.left != null) {
            step(node.left!!)
        } else {
            false to false
        }
        val rightResult = if (node.`val` < q.`val` && node.right != null) {
            step(node.right!!)
        } else {
            false to false
        }

        val result = leftResult + rightResult + ((node == p) to (node == q))
        if (result.first && result.second) {
            ancestor = ancestor ?: node
        }
        return result
    }

}