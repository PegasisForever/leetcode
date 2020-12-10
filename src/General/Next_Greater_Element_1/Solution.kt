package General.Next_Greater_Element_1

import java.util.*

// https://leetcode.com/problems/next-greater-element-i/
class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val nums2RevMap = hashMapOf<Int, Int>()
        val nums2Result = IntArray(nums2.size)
        val stack = Stack<Int>()

        for (i in nums2.indices.reversed()) {
            val num = nums2[i]
            while (stack.isNotEmpty() && stack.peek() <= num) {
                stack.pop()
            }
            nums2Result[i] = if (stack.isEmpty()) {
                -1
            } else {
                stack.peek()
            }
            nums2RevMap[num] = i
            stack.push(num)
        }

        val result = IntArray(nums1.size)
        for (i in nums1.indices) {
            val num = nums1[i]
            val num2Index = nums2RevMap[num]!!
            result[i] = nums2Result[num2Index]
        }

        return result
    }
}
