package Linked_List.Rotate_List

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    Solution().rotateRight(ListNode(1), 1)
}

//https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
class Solution {
    fun rotateRight(head: ListNode?, _k: Int): ListNode? {
        head ?: return null

        var length = 0
        var currNode: ListNode = head
        val endNode: ListNode
        while (true) {
            length++
            if (currNode.next != null) {
                currNode = currNode.next!!
            } else {
                endNode = currNode
                break
            }
        }

        val k = _k % length
        if (k == 0) return head
        currNode = head
        repeat(length - k - 1) {
            currNode = currNode.next!!
        }
        val newHead = currNode.next
        currNode.next = null
        endNode.next = head

        return newHead
    }
}