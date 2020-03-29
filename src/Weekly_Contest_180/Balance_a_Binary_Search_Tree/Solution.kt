package Weekly_Contest_180.Balance_a_Binary_Search_Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/contest/weekly-contest-180/problems/balance-a-binary-search-tree/
class Solution {
    fun balanceBST(root: TreeNode?): TreeNode? {
        root ?: return null
        toListStep(root)
        return toTree(list)
    }

    val list = arrayListOf<Int>()

    fun toListStep(root: TreeNode?) {
        root ?: return

        toListStep(root.left)
        list += root.`val`
        toListStep(root.right)
    }

    fun toTree(l: List<Int>): TreeNode {
        val centerI = l.size / 2
        val node = TreeNode(l[centerI])

        val leftList = l.subList(0, centerI)
        if (leftList.isNotEmpty()) node.left = toTree(leftList)
        val rightList = l.subList(centerI + 1, l.size)
        if (rightList.isNotEmpty()) node.right = toTree(rightList)

        return node
    }
}