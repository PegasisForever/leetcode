package Queue_and_Stack.Implement_Stack_using_Queues

import java.util.*

//https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1387/
class MyStack() {
    val queue: Queue<Int> = LinkedList()

    fun push(x: Int) {
        queue.offer(x)
        repeat(queue.size-1){
            queue.offer(queue.remove())
        }
    }

    fun pop(): Int {
        return queue.remove()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun empty() = queue.isEmpty()

}