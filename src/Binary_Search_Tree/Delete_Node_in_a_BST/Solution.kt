package Binary_Search_Tree.Delete_Node_in_a_BST

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val solution = Solution()
    val tree = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
        right = TreeNode(6).apply {
            right = TreeNode(7)
        }
    }
    solution.deleteNode(tree, 0)
}

//https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1006/
class Solution {
    val TreeNode.size
        get(): Int {
            var size = 0
            if (left != null) size++
            if (right != null) size++
            return size
        }

    fun TreeNode.remove(node: TreeNode) {
        this.replace(node, null)
    }

    fun TreeNode.replace(old: TreeNode?, new: TreeNode?) {
        if (left == old) left = new
        else if (right == old) right = new
    }

    fun deleteNode(_root: TreeNode?, key: Int): TreeNode? {
        val (parent, node) = searchBST(_root, key) ?: return _root
        var root = _root
        when (node.size) {
            0 -> if (parent == null) {
                root = null
            } else {
                parent.remove(node)
            }
            1 -> if (parent == null) {
                root = node.left ?: node.right
            } else {
                val child = node.left ?: node.right
                parent.replace(node, child)
            }
            2 -> {
                val successor = inorderSuccessor(root!!, node)!!
                val needRemoveParent = searchBST(root, successor.`val`)!!.first!!
                val temp = successor.`val`
                successor.`val` = node.`val`
                node.`val` = temp

                val needRemove = successor
                val child = needRemove.left ?: needRemove.right
                if (needRemoveParent.left?.`val` == needRemove.`val`) needRemoveParent.left = child
                else if (needRemoveParent.right?.`val` == needRemove.`val`) needRemoveParent.right = child
            }
        }

        return root
    }

    //return: parent to node
    fun searchBST(root: TreeNode?, target: Int): Pair<TreeNode?, TreeNode>? {
        root ?: return null
        var parent: TreeNode? = null
        var curr = root
        while (curr != null) {
            val oldCurr = curr
            curr = when {
                curr.`val` == target -> return parent to curr
                curr.`val` < target -> curr.right
                else -> curr.left
            }
            parent = oldCurr
        }
        return null
    }

    fun inorderSuccessor(root: TreeNode, node: TreeNode): TreeNode? {
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
}