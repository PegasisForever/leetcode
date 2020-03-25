package Linked_List.Linked_List_Cycle

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/
class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var fast = head
        var slow = head
        while (true) {
            fast = fast?.next?.next
            slow = slow?.next
            if (fast == null) return false
            if (fast == slow) return true
        }
    }
}