package Queue_and_Stack.Target_Sum

fun main() {
    val data = arrayOf(
        intArrayOf(1, 1, 1, 1, 1)
    )
    val solution = Solution()
    for (d in data) {
        println(solution.findTargetSumWays(d, 3))
    }
}

//https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1389/
class Solution {
    var target = 0
    lateinit var nums: IntArray
    var count = 0

    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        if (nums.size == 0) return 0
        this.target = S
        this.nums = nums

        DFS(0, 0)

        return count
    }

    fun DFS(step: Int, currentSum: Int) {
        if (step == nums.size) {
            if (currentSum == target) count++
            return
        }

        DFS(step + 1, currentSum + nums[step])
        DFS(step + 1, currentSum - nums[step])
    }
}