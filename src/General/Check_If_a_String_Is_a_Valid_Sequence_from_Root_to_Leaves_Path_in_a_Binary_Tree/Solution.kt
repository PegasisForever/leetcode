package General.Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    Solution().isValidSequence(
        TreeNode(0).apply {
            left = TreeNode(1).apply {
                left = TreeNode(0).apply {
                    right = TreeNode(1)
                }
                right = TreeNode(1).apply {
                    left = TreeNode(0)
                    right = TreeNode(0)
                }
            }
            right = TreeNode(0).apply {
                left = TreeNode(0)
            }
        },
        intArrayOf(0, 1, 0, 1)
    )
}

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
class Solution {
    fun TreeNode.isLeaf() = left == null && right == null
    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
        if (root == null) return arr.isEmpty()
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        arr.forEachIndexed { depth, num ->
            if (queue.isEmpty()) return false
            repeat(queue.size) {
                val node = queue.poll()
                if (node.`val` == num) {
                    if (depth == arr.lastIndex) {
                        if (node.isLeaf()) return true
                    } else {
                        if (node.left != null) queue.offer(node.left)
                        if (node.right != null) queue.offer(node.right)
                    }
                }
            }
        }

        return false
    }
}