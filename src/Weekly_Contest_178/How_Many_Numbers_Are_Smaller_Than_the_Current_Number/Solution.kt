package Weekly_Contest_178.How_Many_Numbers_Are_Smaller_Than_the_Current_Number

//https://leetcode.com/contest/weekly-contest-178/problems/how-many-numbers-are-smaller-than-the-current-number/
class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val sortedNum = nums.sorted()
        return IntArray(sortedNum.size) { i ->
            val num = nums[i]
            var sortedI = sortedNum.binarySearch(num)
            while (sortedI != 0) {
                if (sortedNum[sortedI - 1] == sortedNum[sortedI]) {
                    sortedI--
                } else {
                    break
                }
            }
            sortedI
        }
    }
}