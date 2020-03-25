package Linked_List.Merge_Two_Sorted_Lists

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    Solution().mergeTwoLists(
        ListNode(1).apply { next = ListNode(2).apply { next = ListNode(4) } },
        ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
    )
}

//https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var currNode1 = l1
        var currNode2 = l2
        var newHead: ListNode? = null
        var currNewNode: ListNode? = null
        fun appendNode(node: ListNode) {
            if (newHead == null) {
                newHead = node
                currNewNode = node
            } else {
                currNewNode!!.next = node
                currNewNode = node
            }
        }

        while (currNode1 != null && currNode2 != null) {
            if (currNode1.`val` < currNode2.`val`) {
                appendNode(currNode1)
                currNode1 = currNode1.next
            } else {
                appendNode(currNode2)
                currNode2 = currNode2.next
            }
        }

        if (currNode1 != null) appendNode(currNode1)
        if (currNode2 != null) appendNode(currNode2)

        return newHead
    }
}