package weekly_Contest_191.Maximum_Product_of_Two_Elements_in_an_Array

// https://leetcode.com/contest/weekly-contest-191/problems/maximum-product-of-two-elements-in-an-array/
class Solution {
    fun maxProduct(nums: IntArray): Int {
        val sorted = nums.sorted().asReversed()
        return (sorted[0] - 1) * (sorted[1] - 1)
    }
}
