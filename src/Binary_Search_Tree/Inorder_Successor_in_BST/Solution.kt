package Binary_Search_Tree.Inorder_Successor_in_BST

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun inorderSuccessor(root: TreeNode?, node: TreeNode?): TreeNode? {
    root ?: return null
    node ?: return null

    var result: TreeNode? = null
    var lastValue: Int? = null
    val p = node.`val`

    fun step(root: TreeNode?) {
        root ?: return
        if (result != null) return

        step(root.left)
        if (lastValue == p) {
            if (result == null) result = root
        } else {
            lastValue = root.`val`
        }
        step(root.right)
    }
    step(root)
    return result
}

//https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/998/
class Solution {
    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        root ?: return null
        p ?: return null
        this.p = p.`val`
        step(root)
        return result
    }

    var result: TreeNode? = null
    var lastValue: Int? = null
    var p = 0

    fun step(root: TreeNode?) {
        root ?: return
        if (result != null) return

        step(root.left)
        if (lastValue == p) {
            if (result == null) result = root
        } else {
            lastValue = root.`val`
        }
        step(root.right)
    }
}
