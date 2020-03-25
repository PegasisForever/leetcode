package Linked_List.Add_Two_Numbers

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/
class Solution {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        var currNode1 = l1
        var currNode2 = l2

        while (true) {
            currNode1.`val` += currNode2.`val`
            val nextNode1 = currNode1.next
            if (nextNode1 == null) {
                currNode1.next = currNode2.next
                break
            } else {
                currNode1 = nextNode1
            }
            currNode2 = currNode2.next ?: break
        }

        currNode1 = l1
        var carry = 0
        while (true) {
            currNode1.`val` += carry
            carry = currNode1.`val` / 10
            currNode1.`val` %= 10

            val nextNode1 = currNode1.next
            if (nextNode1 == null) {
                if (carry != 0) {
                    currNode1.next = ListNode(carry)
                    carry = 0
                    currNode1 = currNode1.next!!
                } else {
                    break
                }
            } else {
                currNode1 = nextNode1
            }
        }

        return l1
    }
}