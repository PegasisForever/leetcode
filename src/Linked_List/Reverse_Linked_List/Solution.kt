package Linked_List.Reverse_Linked_List

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        head ?: return null

        var newHead: ListNode = head
        while (true) {
            val next = head.next
            if (next == null) return newHead

            val nextNext = next.next

            next.next = newHead
            newHead = next

            head.next = nextNext
        }
    }
}