package Array_and_String.Largest_Number_At_Least_Twice_of_Others

//https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
class Solution {
    fun dominantIndex(nums: IntArray): Int {
        var largest = -1
        var largestIndex = -1
        var secondLargest = -1
        nums.forEachIndexed { index, num ->
            if (num > largest) {
                secondLargest = largest
                largest = num
                largestIndex = index
            } else if (num > secondLargest) {
                secondLargest = num
            }
        }

        return if (secondLargest * 2 <= largest) largestIndex else -1
    }
}