package Weekly_contest_209.Even_Odd_Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    Solution().isEvenOddTree(TreeNode(5).apply {
        left = TreeNode(4).apply {
            left = TreeNode(3)
            right = TreeNode(3)
        }
        right = TreeNode(2).apply {
            left = TreeNode(7)
        }
    })
}

// https://leetcode.com/contest/weekly-contest-209/problems/even-odd-tree/
class Solution {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        root ?: return true
        return step(root, 0)
    }

    val levels = ArrayList<ArrayList<Int>>()

    fun Int.isEven() = this % 2 == 0

    fun checkValue(value: Int, level: Int): Boolean {
        repeat((level - levels.size + 1).coerceAtLeast(0)) {
            levels.add(arrayListOf())
        }
        val arr = levels[level]
        arr.add(value)
        if (level.isEven()) { // even
            if (value.isEven()) return false
            if (arr.size > 1 && value <= arr[arr.size - 2]) return false
        } else { // odd
            if (!value.isEven()) return false
            if (arr.size > 1 && value >= arr[arr.size - 2]) return false
        }
        return true
    }

    fun step(node: TreeNode, level: Int): Boolean {
        if (!checkValue(node.`val`, level)) return false
        if (node.left != null) {
            if (!step(node.left!!, level + 1)) return false
        }
        if (node.right != null) {
            if (!step(node.right!!, level + 1)) return false
        }
        return true
    }
}
