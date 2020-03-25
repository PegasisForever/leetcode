package Linked_List.Linked_List_Cycle_2

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        head ?: return null
        var current: ListNode? = head
        val visited = hashSetOf<ListNode>()

        while (true) {
            if (current in visited) return current
            if (current == null) return null
            visited.add(current)
            current = current.next
        }
    }
}