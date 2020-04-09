package General.Middle_of_the_Linked_List

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3290/
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        head ?: return null
        var fast = head
        var slow = head
        while (true) {
            if (fast?.next?.next != null) {
                fast = fast.next?.next
                slow = slow?.next ?: head
            } else if (fast?.next != null) {
                return slow?.next
            } else {
                return slow
            }
        }
    }
}