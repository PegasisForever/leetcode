package Linked_List.Remove_Nth_Node_From_End_of_List

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast: ListNode? = head
        var slow: ListNode? = head

        repeat(n) {
            fast = fast?.next
        }
        if (fast == null) return head?.next

        while (true) {
            val nextFast = fast!!.next
            if (nextFast == null) {
                slow!!.next = slow.next!!.next
                return head
            }
            fast = nextFast
            slow = slow!!.next
        }
    }
}