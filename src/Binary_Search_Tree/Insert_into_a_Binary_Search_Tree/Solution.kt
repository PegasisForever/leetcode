package Binary_Search_Tree.Insert_into_a_Binary_Search_Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1003/
class Solution {
    fun insertIntoBST(root: TreeNode?, insert: Int): TreeNode? {
        root ?: return null
        var curr = root
        while (true) {
            val next = when {
                curr!!.`val` < insert -> curr.right
                curr.`val` > insert -> curr.left
                else -> error("wtf")
            }
            if (next == null) break
            curr = next
        }
        when {
            curr!!.`val` < insert -> curr.right = TreeNode(insert)
            curr.`val` > insert -> curr.left = TreeNode(insert)
        }

        return root
    }
}