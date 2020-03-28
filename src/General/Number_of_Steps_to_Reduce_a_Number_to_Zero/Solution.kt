package General.Number_of_Steps_to_Reduce_a_Number_to_Zero

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
class Solution {
    fun numberOfSteps(num: Int): Int {
        var step = 0
        var n = num
        while (n != 0) {
            if (n.isOdd()) {
                n--
            } else {
                n /= 2
            }
            step++
        }
        return step
    }

    fun Int.isOdd() = this % 2 == 1
}