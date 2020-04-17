package Weekly_Contest_30.a

//https://leetcode.com/contest/leetcode-weekly-contest-30/problems/reshape-the-matrix/
class Solution {
    fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val height = nums.size
        if (height == 0) return nums
        val width = nums[0].size
        if (width == 0) return nums

        if (r * c != width * height) return nums

        var x = 0
        var y = 0
        val result = Array(r) { IntArray(c) }
        nums.forEach { line ->
            line.forEach { int ->
                result[y][x] = int
                x++
                if (x >= c) {
                    x = 0
                    y++
                }
            }
        }
        return result
    }
}