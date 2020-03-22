package Weekly_Contest_181.Create_Target_Array_in_the_Given_Order

fun main() {
    val nums= intArrayOf(1)
    val index= intArrayOf(0)
    println(Solution().createTargetArray(nums, index).joinToString())
}

//https://leetcode.com/contest/weekly-contest-181/problems/create-target-array-in-the-given-order/
class Solution {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val array= arrayListOf<Int>()
        nums.forEachIndexed{i,value->
            array.add(index[i],value)
        }

        return array.toIntArray()
    }
}