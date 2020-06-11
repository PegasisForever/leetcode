package Weekly_Contest_190.Pseudo_Palindromic_Paths_in_a_Binary_Tree

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/contest/weekly-contest-190/problems/pseudo-palindromic-paths-in-a-binary-tree/
class Solution {
    fun isPalin(arr: IntArray): Boolean {
        var odd = false
        arr.forEach { count ->
            if (count % 2 == 1) {
                if (!odd) {
                    odd = true
                } else {
                    return false
                }
            }
        }
        return true
    }

    fun pseudoPalindromicPaths(root: TreeNode): Int {
        val queue: Queue<TreeNode> = LinkedList()
        val countQueue: Queue<IntArray> = LinkedList()
        queue.add(root)
        countQueue.add(IntArray(9).apply { this[root.`val` - 1] = 1 })
        var count = 0

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val node = queue.poll()
                val countArr = countQueue.poll()
                if (node.left == null && node.right == null && isPalin(countArr)) {
                    count++
                }
                if (node.left != null) {
                    queue.offer(node.left)
                    countQueue.offer(countArr.copyOf().apply {
                        this[node.left!!.`val` - 1]++
                    })
                }
                if (node.right != null) {
                    queue.offer(node.right)
                    countQueue.offer(countArr.copyOf().apply {
                        this[node.right!!.`val` - 1]++
                    })
                }
            }
        }

        return count
    }
}
