package General.Construct_Binary_Search_Tree_from_Preorder_Traversal

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3305/
class Solution {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        return step(preorder.asList())
    }

    fun step(list: List<Int>): TreeNode? {
        if (list.isEmpty()) return null

        val node = TreeNode(list.first())

        val rightStartIndex = list.indexOfFirst { it > node.`val` }
        if (rightStartIndex >= 0) {
            node.left = step(list.subList(1, rightStartIndex))
            node.right = step(list.subList(rightStartIndex, list.size))
        } else {
            node.left = step(list.subList(1, list.size))
        }

        return node
    }
}