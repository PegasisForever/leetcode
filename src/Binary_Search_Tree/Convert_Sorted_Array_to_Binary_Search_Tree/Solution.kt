package Binary_Search_Tree.Convert_Sorted_Array_to_Binary_Search_Tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        return toTree(nums.asList())
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