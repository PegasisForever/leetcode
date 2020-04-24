package Binary_Search.Closest_Binary_Search_Tree_Value

import kotlin.math.abs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/1028/
class Solution {
    fun closestValue(root: TreeNode?, target: Double): Int {
        var closest = 0
        var closestDiff = Double.MAX_VALUE
        var curr = root!!
        while (true) {
            val diff = abs(target - curr.`val`)
            if (diff < closestDiff) {
                closest = curr.`val`
                closestDiff = diff
                if (diff <= 0.5) break
            }
            curr = if (target > curr.`val`) {
                curr.right
            } else {
                curr.left
            } ?: break
        }
        return closest
    }
}