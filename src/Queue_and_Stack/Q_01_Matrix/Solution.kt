package Queue_and_Stack.Q_01_Matrix

import java.util.*

//https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388/
class Solution {
    data class Pos(val x: Int, val y: Int)

    fun Pos.possibleNextPoses() = arrayOf(
        copy(x = x + 1),
        copy(x = x - 1),
        copy(y = y + 1),
        copy(y = y - 1)
    )

    operator fun Array<IntArray>.get(pos: Pos) = this[pos.y][pos.x]
    operator fun Array<IntArray>.set(pos: Pos, value: Int) {
        this[pos.y][pos.x] = value
    }

    fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
        val width = matrix[0].size
        val height = matrix.size
        fun Pos.isInImage() = (this.x in 0 until width) && (this.y in 0 until height)

        val visited = hashSetOf<Pos>()
        val queue: Queue<Pos> = LinkedList()
        var step = -1

        matrix.forEachIndexed { y, row ->
            row.forEachIndexed { x, value ->
                if (value == 0) {
                    queue.add(Pos(x, y))
                    visited.add(Pos(x, y))
                }
            }
        }

        while (queue.isNotEmpty()) {
            step++
            repeat(queue.size) {
                val currentPos = queue.remove()
                matrix[currentPos] = step
                for (nextPos in currentPos.possibleNextPoses()) if (nextPos.isInImage() && nextPos !in visited) {
                    queue.offer(nextPos)
                    visited.add(nextPos)
                }
            }
        }

        return matrix
    }
}