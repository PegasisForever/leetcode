package Array_and_String.Remove_Element

fun main() {
    val array= intArrayOf(2,2,3)
    println(Solution().removeElement(array,2))
    println(array.joinToString())
}

//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1151/
class Solution {
    fun removeElement(nums: IntArray, replace: Int): Int {
        var slow = 0
        repeat(nums.size) { i ->
            if (nums[i] != replace) {
                nums[slow] = nums[i]
                slow++
            }
        }
        return slow
    }
}