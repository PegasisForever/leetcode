package Binary_Tree.Symmetric_Tree

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = TreeNode(5).apply {
        left = TreeNode(4).apply {
            right = TreeNode(1).apply {
                left = TreeNode(2)
            }
        }
        right = TreeNode(1).apply {
            right = TreeNode(4).apply {
                left = TreeNode(2)
            }
        }
    }

    println(Solution().isSymmetric(root))
}

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return areNodesSymmetric(root.left, root.right)
    }

    fun areNodesSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        if (left.`val` != right.`val`) return false
        if (left.isLeaf() && right.isLeaf()) return true
        if (areNodesSymmetric(left.left, right.right) && areNodesSymmetric(left.right, right.left)) return true
        return false
    }

    fun TreeNode.isLeaf() = left == null && right == null
}

class Solution2 {
    fun isSymmetric(root: TreeNode?): Boolean {
        maxDepth = maxDepth(root)
        val list = step(root, 0)
        for (i in 0..list.lastIndex / 2) {
            if (list[i] != list[list.lastIndex - i]) return false
        }

        return true
    }

    var maxDepth = 0

    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return max(maxDepth(root.left), maxDepth(root.right)) + 1
    }

    fun step(root: TreeNode?, depth: Int): ArrayList<Int?> {
        var r = root

        if (r == null) {
            if (depth < maxDepth) {
                r = TreeNode(Int.MAX_VALUE)
            } else {
                return arrayListOf(null)
            }
        }
        return step(r.left, depth + 1).apply {
            add(r.`val`)
            addAll(step(r.right, depth + 1))
        }
    }
}