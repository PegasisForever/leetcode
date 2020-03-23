package Queue_and_Stack.Number_of_Islands_DFS

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(Solution().numIslands(grid))
}

class Solution {
    var height = 0
    var width = 0
    lateinit var grid: Array<CharArray>

    data class Pos(val x: Int, val y: Int)

    operator fun Array<CharArray>.get(pos: Pos) = this[pos.y][pos.x] == '1'
    operator fun Array<CharArray>.set(pos: Pos, value: Char) {
        this[pos.y][pos.x] = value
    }

    fun Pos.isInRange() = (this.x in 0 until width) && (this.y in 0 until height)

    fun Pos.isLand() = if (isInRange()) grid[this] else false

    fun Pos.possibleDirections() = listOf(
        this.copy(x = this.x + 1),
        this.copy(x = this.x - 1),
        this.copy(y = this.y + 1),
        this.copy(y = this.y - 1)
    )

    fun DFS(currentPos: Pos) {
        grid[currentPos] = '0'
        for (nextPos in currentPos.possibleDirections()) {
            if (nextPos.isLand()) {
                DFS(nextPos)
            }
        }
    }

    fun numIslands(grid: Array<CharArray>): Int {
        this.height = grid.size
        if (height == 0) return 0
        this.width = grid[0].size
        if (width == 0) return 0
        this.grid = grid


        var islandCount = 0
        for (x in 0 until width) for (y in 0 until height) {
            if (grid[y][x] == '1') {
                DFS(Pos(x, y))
                islandCount++
            }
        }

        return islandCount
    }
}
