package Array_and_String.Two_Sum_2_Input_array_is_sorted

//https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1153/
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.lastIndex

        while (true) {
            val sum = numbers[i] + numbers[j]
            when {
                sum == target -> return intArrayOf(i + 1, j + 1)
                sum > target -> j--
                sum < target -> i++
            }
        }
    }
}

class Solution2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        while (true) {
            val j = numbers.binarySearch(target - numbers[i])
            if (j >= 0 && j != i) {
                return intArrayOf(i + 1, j + 1).sortedArray()
            }
            i++
        }
    }
}