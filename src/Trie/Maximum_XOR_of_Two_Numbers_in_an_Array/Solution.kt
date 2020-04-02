package Trie.Maximum_XOR_of_Two_Numbers_in_an_Array

import java.util.*

fun main() {
    val data = arrayOf(
        intArrayOf(3,10,5,25,2,8)
    )
    val solution = Solution()
    for (d in data) {
        println(solution.findMaximumXOR(d))
    }
}

//https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1057/
class Solution {
    data class Node(var zero: Node? = null, var one: Node? = null)

    val root = Node()

    fun Int.toBitArray(): BooleanArray {
        return BooleanArray(31) { i ->
            ((this shr (30 - i)) and 1) == 1
        }
    }

    fun add(num: Int) {
        val bits = num.toBitArray()
        var curr = root
        bits.forEach { bit ->
            if (bit) {
                val next = curr.one ?: Node()
                curr.one = next
                curr = next
            } else {
                val next = curr.zero ?: Node()
                curr.zero = next
                curr = next
            }
        }
    }

    fun findMaximumXOR(nums: IntArray): Int {
        nums.forEach { add(it) }

        val nodeAs: Queue<Node> = LinkedList()
        nodeAs.add(root)
        val nodeBs: Queue<Node> = LinkedList()
        nodeBs.add(root)
        var base = 1073741824
        var maxXor = 0

        repeat(31) {
            val goodNextANodes = arrayListOf<Node>()
            val goodNextBNodes = arrayListOf<Node>()
            val badNextANodes = arrayListOf<Node>()
            val badNextBNodes = arrayListOf<Node>()
            repeat(nodeAs.size) {
                val nodeA = nodeAs.poll()
                val nodeB = nodeBs.poll()
                if (nodeA.one != null && nodeB.zero != null) {
                    goodNextANodes += nodeA.one!!
                    goodNextBNodes += nodeB.zero!!
                }
                if (nodeA.zero != null && nodeB.one != null) {
                    goodNextANodes += nodeA.zero!!
                    goodNextBNodes += nodeB.one!!
                }

                if (goodNextANodes.isEmpty()){
                    if (nodeA.one!=null && nodeB.one!=null){
                        badNextANodes+=nodeA.one!!
                        badNextBNodes+=nodeB.one!!
                    }
                    if (nodeA.zero!=null && nodeB.zero!=null){
                        badNextANodes+=nodeA.zero!!
                        badNextBNodes+=nodeB.zero!!
                    }
                }
            }
            if (goodNextANodes.isNotEmpty()){
                goodNextANodes.forEach { nodeAs.add(it) }
                goodNextBNodes.forEach { nodeBs.add(it) }
                maxXor+=base
            }else{
                badNextANodes.forEach { nodeAs.add(it) }
                badNextBNodes.forEach { nodeBs.add(it) }
            }
            base /= 2
        }

        return maxXor
    }
}