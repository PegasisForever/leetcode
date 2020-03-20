package Queue_and_Stack.Moving_Average_from_Data_Stream

import java.util.*

//https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1368/
class MovingAverage(private val size: Int) {
    val queue: Queue<Int> = LinkedList()

    fun next(`val`: Int): Double {
        queue.offer(`val`)
        if (queue.size > size) queue.remove()
        return queue.sum().toDouble() / queue.size
    }

}