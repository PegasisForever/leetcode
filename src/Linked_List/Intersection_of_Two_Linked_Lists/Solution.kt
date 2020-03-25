package Linked_List.Intersection_of_Two_Linked_Lists

import kotlin.math.min

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

//https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var currA: ListNode? = headA
        var aLength = 0
        while (currA != null) {
            aLength++
            currA = currA.next
        }

        var currB: ListNode? = headB
        var bLength = 0
        while (currB != null) {
            bLength++
            currB = currB.next
        }

        currA = headA
        currB = headB
        if (aLength > bLength) repeat(aLength - bLength) {
            currA = currA!!.next
        }
        if (bLength > aLength) repeat(bLength - aLength) {
            currB = currB!!.next
        }

        repeat(min(aLength, bLength)) {
            if (currA == currB) return currA
            currA = currA!!.next
            currB = currB!!.next
        }

        return if (currA == currB) currA else null
    }
}