package Binary_Search_Tree.Validate_Binary_Search_Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/997/
class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        step(root)
        return result
    }

    var result = true
    var lastValue:Int? = null

    fun step(root: TreeNode?) {
        root ?: return
        if (!result) return

        step(root.left)
        if (lastValue==null || root.`val` > lastValue!!) {
            lastValue = root.`val`
        } else {
            result = false
        }
        step(root.right)
    }
}