package Binary_Tree.Count_Univalue_Subtrees

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun countUnivalSubtrees(root: TreeNode?): Int {
        isUnival(root)
        return count
    }

    var count = 0

    fun isUnival(root: TreeNode?): Boolean {
        root ?: return true
        if (root.isLeaf()) {
            count++
            return true
        }

        var isUnival = true
        if (root.left != null) {
            isUnival = isUnival(root.left) && root.left!!.`val` == root.`val` && isUnival
        }
        if (root.right != null) {
            isUnival = isUnival(root.right) && root.right!!.`val` == root.`val` && isUnival
        }

        if (isUnival) count++
        return isUnival
    }

    fun TreeNode.isLeaf() = left == null && right == null
}

class Solution2 {
    fun countUnivalSubtrees(root: TreeNode?): Int {
        step(root)
        return count
    }

    fun step(root: TreeNode?) {
        root ?: return
        if (isUnival(root)) count++
        step(root.left)
        step(root.right)
    }

    var count = 0
    val memo = hashMapOf<TreeNode, Boolean>()

    fun isUnival(root: TreeNode?): Boolean {
        root ?: return false
        if (memo.contains(root)) return memo[root]!!
        if (root.isLeaf()) {
            memo[root] = true
            return true
        }
        if (root.`val` == root.left?.`val` && root.right == null && isUnival(root.left)) {
            memo[root] = true
            return true
        }
        if (root.`val` == root.right?.`val` && root.left == null && isUnival(root.right)) {
            memo[root] = true
            return true
        }
        if (root.`val` == root.right?.`val` && root.`val` == root.left?.`val` && isUnival(root.left) && isUnival(root.right)) {
            memo[root] = true
            return true
        }
        memo[root] = false
        return false
    }

    fun TreeNode.isLeaf() = left == null && right == null
}