package Queue_and_Stack.Design_Circular_Queue

fun main() {
    val queue = MyCircularQueue(2)
    with(queue) {
        println(enQueue(4))
        println(Rear())
        println(enQueue(9))
        println(deQueue())
        println(Front())
        println(deQueue())
        println(deQueue())

    }
}

//https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/
class MyCircularQueue(private val k: Int) {
    val data = IntArray(k)
    var head: Int? = null
    var tail: Int? = null

    fun enQueue(value: Int): Boolean {
        if (tail == null) {
            data[0] = value
            head = 0
            tail = 0
            return true
        }
        val tailAfterAdd = (tail!! + 1) % k
        if (tailAfterAdd == head) {
            return false
        } else {
            tail = tailAfterAdd
            data[tail!!] = value
            return true
        }
    }

    fun deQueue(): Boolean {
        if (head == null) {
            return false
        }
        if (head == tail) {
            head = null
            tail = null
            return true
        } else {
            val headAfterRemove = (head!! + 1) % k
            head = headAfterRemove
            return true
        }
    }

    fun Front() = if (head == null) -1 else data[head!!]

    fun Rear() = if (tail == null) -1 else data[tail!!]

    fun isEmpty() = head == null && tail == null

    fun isFull() = if (isEmpty()) {
        false
    } else {
        (tail!! + 1) % k == head
    }
}