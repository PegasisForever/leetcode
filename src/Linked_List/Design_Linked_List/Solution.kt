package Linked_List.Design_Linked_List

//https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
data class Node(val value: Int, var next: Node? = null)

class MyLinkedList {
    private var size = 0
    private var head: Node? = null

    private fun getNode(index: Int): Node {
        var current = head!!
        repeat(index) {
            current = current.next!!
        }
        return current
    }

    fun get(index: Int): Int {
        if (index < 0 || index >= size) return -1
        return getNode(index).value
    }

    fun addAtHead(value: Int) {
        val newHead = Node(value, head)
        head = newHead
        size++
    }

    fun addAtTail(value: Int) {
        if (size == 0) {
            addAtHead(value)
        } else {
            val oldTail = getNode(size - 1)
            val newTail = Node(value)
            oldTail.next = newTail
            size++
        }
    }

    fun addAtIndex(index: Int, value: Int) {
        if (index < 0 || index > size) return
        if (index == 0) {
            addAtHead(value)
        } else if (index == size) {
            addAtTail(value)
        } else {
            val prevNode = getNode(index - 1)
            val nextNode = prevNode.next!!
            val newNode = Node(value, nextNode)
            prevNode.next = newNode
            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= size) return
        if (index == 0) {
            head = head!!.next
            size--
        } else if (index == size - 1) {
            size--
        } else {
            val prevNode = getNode(index - 1)
            val nextNode = prevNode.next!!.next!!
            prevNode.next = nextNode
            size--
        }
    }
}