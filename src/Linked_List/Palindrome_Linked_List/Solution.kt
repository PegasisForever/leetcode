package Linked_List.Palindrome_Linked_List

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/
class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var length = 0
        var currNode = head
        while (currNode != null) {
            length++
            currNode = currNode.next
        }
        if (length < 2) return true
        if (length == 2) return head!!.`val` == head.next!!.`val`
        if (length == 3) return head!!.`val` == head.next!!.next!!.`val`

        var reversedHead = head!!
        currNode = head.next
        repeat(length / 2 - 1) {
            val nextNode = currNode!!.next
            currNode!!.next = reversedHead
            reversedHead = currNode!!
            currNode = nextNode
        }

        var restHead = if (length % 2 == 0) currNode else currNode!!.next
        repeat(length / 2) {
            if (reversedHead.`val` != restHead!!.`val`) return false
            reversedHead = reversedHead.next!!
            restHead = restHead!!.next
        }

        return true
    }
}