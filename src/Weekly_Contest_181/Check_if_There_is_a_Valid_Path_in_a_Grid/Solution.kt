package Weekly_Contest_181.Check_if_There_is_a_Valid_Path_in_a_Grid

fun main() {
    val grid = arrayOf(
        intArrayOf(2, 4, 3),
        intArrayOf(6, 5, 2)
    )

    println(Solution().hasValidPath(grid))
}

//https://leetcode.com/contest/weekly-contest-181/problems/check-if-there-is-a-valid-path-in-a-grid/
class Solution {
    lateinit var grid: Array<Array<Street>>
    var width = 0
    var height = 0

    fun hasValidPath(grid: Array<IntArray>): Boolean {
        height = grid.size
        width = grid[0].size

        this.grid = Array(height) { y ->
            Array(width) { x ->
                Street(grid[y][x])
            }
        }
        val startPos = Pos(0, 0)
        visited.add(startPos)
        return step(startPos)
    }

    fun step(pos: Pos): Boolean {
        if (pos.isEnd()) return true

        for (nextPos in pos.possibleNextPoses()) {
            if (step(nextPos)) {
                return true
            }
        }
        return false
    }

    data class Pos(val x: Int, val y: Int)

    operator fun Array<Array<Street>>.get(pos: Pos) = this[pos.y][pos.x]

    fun Pos.inGrid() = (x in 0 until width) && (y in 0 until height)

    fun Pos.isEnd() = x == width - 1 && y == height - 1

    val visited = hashSetOf<Pos>()
    fun Pos.possibleNextPoses(): List<Pos> {
        val result = arrayListOf<Pos>()
        for (direction in grid[this].directions) {
            val newPos = this.goto(direction)
            if (newPos.inGrid() && !visited.contains(newPos) && grid[newPos].directions.contains(direction.opposite())) {
                result.add(newPos)
                visited.add(newPos)
            }
        }
        return result
    }

    enum class Direction {
        UP, LEFT, RIGHT, DOWN
    }

    fun Direction.opposite() = when (this) {
        Direction.UP -> Direction.DOWN
        Direction.LEFT -> Direction.RIGHT
        Direction.RIGHT -> Direction.LEFT
        Direction.DOWN -> Direction.UP
    }

    fun Pos.goto(direction: Direction) = when (direction) {
        Direction.UP -> copy(y = y - 1)
        Direction.LEFT -> copy(x = x - 1)
        Direction.RIGHT -> copy(x = x + 1)
        Direction.DOWN -> copy(y = y + 1)
    }

    data class Street(val type: Int) {
        val directions = when (type) {
            1 -> hashSetOf(Direction.LEFT, Direction.RIGHT)
            2 -> hashSetOf(Direction.UP, Direction.DOWN)
            3 -> hashSetOf(Direction.LEFT, Direction.DOWN)
            4 -> hashSetOf(Direction.RIGHT, Direction.DOWN)
            5 -> hashSetOf(Direction.LEFT, Direction.UP)
            6 -> hashSetOf(Direction.RIGHT, Direction.UP)
            else -> error("wtf")
        }
    }
}