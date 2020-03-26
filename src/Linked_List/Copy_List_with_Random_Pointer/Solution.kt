package Linked_List.Copy_List_with_Random_Pointer

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

//https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1229/
class Solution {
    val oldNewMap = hashMapOf<Node, Node>()

    fun copyRandomList(node: Node?): Node? {
        node ?: return null

        if (node in oldNewMap) return oldNewMap[node]

        val newNode = Node(node.`val`)
        oldNewMap[node] = newNode
        newNode.next = copyRandomList(node.next)
        newNode.random = copyRandomList(node.random)
        return newNode
    }
}