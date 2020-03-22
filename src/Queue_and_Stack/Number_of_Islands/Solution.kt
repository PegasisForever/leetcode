package Queue_and_Stack.Number_of_Islands

import java.util.*

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    Solution().numIslands(grid)
}

//https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/
class Solution {
    var height = 0
    var width = 0
    lateinit var grid: Array<CharArray>

    data class Pos(val x: Int, val y: Int)

    operator fun Array<CharArray>.get(pos: Pos) = this[pos.y][pos.x] == '1'
    operator fun Array<CharArray>.set(pos: Pos, value: Char){
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

    fun markIsland(pos: Pos) {
        val queue: Queue<Pos> = LinkedList()
        queue.add(pos)
        grid[pos] = '0'

        while (queue.isNotEmpty()) {
            val currentPos = queue.remove()

            for (nextPos in currentPos.possibleDirections()) {
                if (nextPos.isLand()) {
                    queue.offer(nextPos)
                    grid[nextPos] = '0'
                }
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
                markIsland(Pos(x, y))
                islandCount++
            }
        }

        return islandCount
    }
}

class Solution2 {
    var height = 0
    var width = 0
    lateinit var grid: Array<CharArray>

    data class Pos(val x: Int, val y: Int)

    operator fun Array<CharArray>.get(pos: Pos) = this[pos.y][pos.x] == '1'

    fun Pos.isInRange() = (this.x in 0 until width) && (this.y in 0 until height)

    fun Pos.isLand() = if (isInRange()) grid[this] else false

    fun Pos.possibleDirections() = listOf(
        this.copy(x = this.x + 1),
        this.copy(x = this.x - 1),
        this.copy(y = this.y + 1),
        this.copy(y = this.y - 1)
    )

    fun findIsland(pos: Pos): Set<Pos> {
        val queue: Queue<Pos> = LinkedList()
        val visited = hashSetOf<Pos>()

        queue.add(pos)
        visited.add(pos)

        while (queue.isNotEmpty()) {
            val currentPos = queue.remove()
            if (!currentPos.isLand()) continue

            for (nextPos in currentPos.possibleDirections()) {
                if (!visited.contains(nextPos)) {
                    queue.offer(nextPos)
                    visited.add(nextPos)
                }
            }
        }

        return visited
    }

    fun numIslands(grid: Array<CharArray>): Int {
        this.height = grid.size
        if (height == 0) return 0
        this.width = grid[0].size
        if (width == 0) return 0
        this.grid = grid

        val landSet = hashSetOf<Pos>()
        for (x in 0 until width) for (y in 0 until height) {
            if (grid[y][x] == '1') {
                landSet.add(Pos(x, y))
            }
        }

        var islandCount = 0
        while (landSet.isNotEmpty()) {
            val land = findIsland(landSet.first())
            landSet.removeAll(land)
            islandCount++
        }

        return islandCount
    }
}