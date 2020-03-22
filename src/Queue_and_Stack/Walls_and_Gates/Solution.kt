package Queue_and_Stack.Walls_and_Gates

import java.util.*

fun main() {
    val inf = Int.MAX_VALUE
    val room = arrayOf(
        intArrayOf(inf, -1, 0, -1),
        intArrayOf(inf, inf, inf, -1),
        intArrayOf(inf, -1, inf, -1),
        intArrayOf(0, -1, inf, inf)
    )

    Solution().wallsAndGates(room)
    println(room)
}

//https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1373/
class Solution {

    fun wallsAndGates(rooms: Array<IntArray>) {
        val height = rooms.size
        if (height == 0) return
        val width = rooms[0].size
        if (width == 0) return


        val queue: Queue<Pos> = LinkedList()
        val visited = hashSetOf<Pos>()
        var distance = -1
        var distanceNotFoundCount = 0

        for (x in 0 until width) for (y in 0 until height) {
            if (rooms[y][x] == 0) {
                with(Pos(x, y)) {
                    queue.add(this)
                    visited.add(this)
                }
            } else if (rooms[y][x] > 0) {
                distanceNotFoundCount++
            }
        }

        fun Pos.isInRange() = (this.x in 0 until width) && (this.y in 0 until height)

        while (queue.isNotEmpty()) {
            distance++
            repeat(queue.size) {
                val currentPos = queue.remove()
                if (!currentPos.isInRange()) return@repeat
                if (rooms[currentPos] == -1) return@repeat
                if (rooms[currentPos] == Int.MAX_VALUE) {
                    rooms[currentPos] = distance
                    distanceNotFoundCount--
                    if (distanceNotFoundCount == 0) return
                }

                for (nextPos in currentPos.possibleDirections()) {
                    if (!visited.contains(nextPos)) {
                        queue.offer(nextPos)
                        visited.add(nextPos)
                    }
                }
            }
        }
    }

    operator fun Array<IntArray>.get(pos: Pos) = this[pos.y][pos.x]

    operator fun Array<IntArray>.set(pos: Pos, value: Int) {
        this[pos.y][pos.x] = value
    }

    data class Pos(val x: Int, val y: Int)

    fun Pos.possibleDirections() = listOf(
        this.copy(x = this.x + 1),
        this.copy(x = this.x - 1),
        this.copy(y = this.y + 1),
        this.copy(y = this.y - 1)
    )
}

class Solution2 {
    lateinit var rooms: Array<IntArray>
    var width = 0
    var height = 0

    fun wallsAndGates(rooms: Array<IntArray>) {
        height = rooms.size
        if (height == 0) return
        width = rooms[0].size
        if (width == 0) return

        this.rooms = rooms

        for (x in 0 until width) for (y in 0 until height) {
            if (rooms[y][x] > 0) {
                rooms[y][x] = findNearestGate(Pos(x, y))
            }
        }
    }

    fun findNearestGate(start: Pos): Int {
        val queue: Queue<Pos> = LinkedList()
        val visited = hashSetOf<Pos>()
        var distance = -1

        queue.offer(start)
        visited.add(start)

        while (queue.isNotEmpty()) {
            distance++

            repeat(queue.size) {
                val currentPos = queue.remove()
                if (!currentPos.isInRange()) return@repeat
                if (rooms[currentPos] == -1) return@repeat
                if (rooms[currentPos] == 0) return distance

                for (nextPos in currentPos.possibleDirections()) {
                    if (!visited.contains(nextPos)) {
                        queue.offer(nextPos)
                        visited.add(nextPos)
                    }
                }
            }
        }

        return Int.MAX_VALUE
    }

    operator fun Array<IntArray>.get(pos: Pos) = this[pos.y][pos.x]

    data class Pos(val x: Int, val y: Int)

    fun Pos.isInRange() = (this.x in 0 until width) && (this.y in 0 until height)

    fun Pos.possibleDirections() = listOf(
        this.copy(x = this.x + 1),
        this.copy(x = this.x - 1),
        this.copy(y = this.y + 1),
        this.copy(y = this.y - 1)
    )
}