package N_ary_Tree.Maximum_Depth_of_N_ary_Tree

import kotlin.math.max

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

class Solution {
    fun maxDepth(root: Node?): Int {
        var maxDepth = 0
        root ?: return maxDepth
        root.children.forEach { maxDepth = max(maxDepth, maxDepth(it)) }
        return maxDepth + 1
    }
}