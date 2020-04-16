package General.Product_of_Array_Except_Self

fun main() {
    Solution().productExceptSelf(intArrayOf(1, 2, 3, 4))
}

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val left = IntArray(nums.size)
        for (i in 1..nums.lastIndex) {
            left[i] = if (i == 1) nums[i - 1] else left[i - 1] * nums[i - 1]
        }

        val right = IntArray(nums.size)
        for (i in nums.lastIndex - 1 downTo 0) {
            right[i] = if (i == nums.lastIndex - 1) nums[i + 1] else right[i + 1] * nums[i + 1]
        }

        return IntArray(nums.size) { i ->
            when (i) {
                0 -> right[i]
                nums.lastIndex -> left[i]
                else -> left[i] * right[i]
            }
        }
    }
}