package Queue_and_Stack.Flood_Fill

import java.util.*

//https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/
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

    fun floodFill(image: Array<IntArray>, startY: Int, startX: Int, newColor: Int): Array<IntArray> {
        val width = image[0].size
        val height = image.size
        fun Pos.isInImage() = (this.x in 0 until width) && (this.y in 0 until height)

        val queue: Queue<Pos> = LinkedList()
        val startPos = Pos(startX, startY)
        val startColor = image[startPos]
        if (startColor == newColor) return image
        queue.add(startPos)


        while (queue.isNotEmpty()) {
            val currentPos = queue.remove()
            if (image[currentPos] == startColor) {
                image[currentPos] = newColor
                for (nextPos in currentPos.possibleNextPoses()) if (nextPos.isInImage()) {
                    queue.add(nextPos)
                }
            }
        }

        return image
    }
}