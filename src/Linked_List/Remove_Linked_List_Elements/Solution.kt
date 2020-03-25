package Linked_List.Remove_Linked_List_Elements

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
class Solution {
    fun removeElements(head: ListNode?, value: Int): ListNode? {
        head ?: return null

        var current: ListNode = head
        while (true) {
            val next = current.next
            if (next == null) break

            if (next.`val` == value) {
                current.next = next.next
            } else {
                current = next
            }
        }

        return if (head.`val`==value) head.next else head
    }
}