package Linked_List.Odd_Even_Linked_List

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/
class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        var slow = head ?: return head
        var fast = slow.next ?: return head

        while (true) {
            val nextFast = fast.next?.next
            val evenNode = fast.next ?: return head

            fast.next = fast.next!!.next
            if (nextFast != null) fast = nextFast

            val nextSlow = slow.next!!
            evenNode.next = nextSlow
            slow.next = evenNode
            slow = evenNode
        }
    }
}