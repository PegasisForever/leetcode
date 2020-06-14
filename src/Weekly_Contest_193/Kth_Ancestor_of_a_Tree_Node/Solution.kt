package Weekly_Contest_193.Kth_Ancestor_of_a_Tree_Node

import kotlin.math.log2

// https://leetcode.com/contest/weekly-contest-193/problems/kth-ancestor-of-a-tree-node/
class TreeAncestor(val n: Int, val parentOf: IntArray) {
    val jumpLists = arrayListOf<IntArray>()
    val maxStep: Int

    init {
        jumpLists.add(parentOf)
        var lastList = parentOf
        repeat(log2(parentOf.size.toDouble()).toInt()-1){
            val list = IntArray(parentOf.size) { index ->
                val pre = lastList[index]
                if (pre == -1) {
                    -1
                } else {
                    lastList[pre]
                }
            }
            jumpLists.add(list)
            lastList = list
        }
        maxStep = jumpLists.size - 1
    }

    fun getKthAncestor(inNode: Int, k: Int): Int {
        var kLeft = k
        var node = inNode
        for (step in maxStep downTo 0) {
            val realStep = 1 shl step
            while (kLeft >= realStep) {
                node = jumpLists[step].getOrNull(node) ?: return -1
                kLeft -= realStep
            }
        }
        return node
    }
}
