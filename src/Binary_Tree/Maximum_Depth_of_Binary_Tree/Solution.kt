package Binary_Tree.Maximum_Depth_of_Binary_Tree

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}

