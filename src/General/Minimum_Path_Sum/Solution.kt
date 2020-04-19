package General.Minimum_Path_Sum

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3303/
class Solution {
    data class Pos(val x: Int, val y: Int) {
        fun nextPossiblePos() = arrayOf(
            copy(x = x + 1),
            copy(y = y + 1)
        )
    }

    fun Pos.isInGrid() = (x in 0 until width) && (y in 0 until height)
    fun Pos.isEnd() = x == width - 1 && y == height - 1
    operator fun Array<IntArray>.get(pos: Pos) = this[pos.y][pos.x]

    lateinit var grid: Array<IntArray>
    var width = 0
    var height = 0
    var minSum = Int.MAX_VALUE
    val memo = hashMapOf<Pos, Int>()

    fun minPathSum(g: Array<IntArray>): Int {
        grid = g
        height = g.size
        width = g[0].size

        return step(Pos(0, 0))
    }

    fun step(pos: Pos): Int {
        if (pos.isEnd()) return grid[pos]
        if (pos in memo) return memo[pos]!!

        var min = Int.MAX_VALUE
        pos.nextPossiblePos().forEach { nextPos ->
            if (nextPos.isInGrid()) {
                min = minOf(min, step(nextPos) + grid[pos])
            }
        }
        memo[pos] = min
        return min
    }
}