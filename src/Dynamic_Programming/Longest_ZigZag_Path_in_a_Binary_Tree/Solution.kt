package Dynamic_Programming.Longest_ZigZag_Path_in_a_Binary_Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
class Solution {
    fun longestZigZag(root: TreeNode?): Int {
        root ?: return 0
        step(root)
        return max
    }

    val cache = hashMapOf<TreeNode, Pair<Int, Int>>()
    var max = 0

    fun step(node: TreeNode): Pair<Int, Int> {
        if (node in cache) return cache[node]!!

        var leftCount = 0
        if (node.left != null) {
            leftCount = step(node.left!!).second + 1
        }

        var rightCount = 0
        if (node.right != null) {
            rightCount = step(node.right!!).first + 1
        }

        max = maxOf(max, leftCount, rightCount)

        return (leftCount to rightCount).also { cache[node] = it }
    }
}
