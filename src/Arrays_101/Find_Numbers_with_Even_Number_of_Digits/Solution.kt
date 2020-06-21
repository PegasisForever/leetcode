package Arrays_101.Find_Numbers_with_Even_Number_of_Digits

//https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3237/
class Solution {
    fun findNumbers(nums: IntArray): Int {
        return nums.map { it.toString().length }.count { it % 2 == 0 }
    }
}
