package Queue_and_Stack.Keys_and_Rooms

import java.util.*

//https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1391/
class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = hashSetOf<Int>()
        val queue: Queue<Int> = LinkedList()

        queue.add(0)
        visited.add(0)
        while (queue.isNotEmpty()) {
            val currentRoom = queue.remove()
            for (nextRoom in rooms[currentRoom]) if (nextRoom !in visited) {
                queue.add(nextRoom)
                visited.add(nextRoom)
            }
        }

        return visited.size == rooms.size
    }
}