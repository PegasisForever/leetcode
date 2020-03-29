package Binary_Search_Tree.Search_in_a_Binary_Search_Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1000/
class Solution {
    fun searchBST(root: TreeNode?, target: Int): TreeNode? {
        root ?: return null
        var curr = root
        while (curr != null) {
            curr = when {
                curr.`val` == target -> return curr
                curr.`val` < target -> curr.right
                else -> curr.left
            }
        }
        return null
    }
}