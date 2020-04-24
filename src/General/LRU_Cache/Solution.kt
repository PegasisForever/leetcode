package General.LRU_Cache

fun main() {
    val solution = LRUCache(2)
    solution.put(1, 1)
    solution.put(2, 2)
    solution.get(1)
    solution.put(3, 3)
    solution.get(2)
    solution.put(4, 4)
    solution.get(1)
    solution.get(3)
    solution.get(4)
}

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3309/
class LRUCache(val capacity: Int) {
    private inner class Node(var value: Int) {
        var inList = false
        var prev: Node? = null
        var next: Node? = null

        override fun toString() = "Node(${value}, prev=${prev?.value}, next=${next?.value})"

        fun insertToListHead() {
            if (inList) error("Node is already in list!")
            inList = true
            size++
            if (head == null) {
                head = this
                tail = this
            } else {
                this.next = head
                head!!.prev = this
                head = this
            }
        }

        fun moveToListHead() {
            if (!inList) error("Node is not in list!")
            if (head == null) {
                head = this
                tail = this
            } else if (this != head) {
                //remove
                if (next == null) {
                    removeTailNode(false)
                } else {
                    prev!!.next = next
                    next!!.prev = prev
                }

                //insert
                this.prev = null
                this.next = head
                head!!.prev = this
                head = this
            }
        }
    }

    private fun removeTailNode(shrinkSize: Boolean = true) {
        tail ?: return
        if (shrinkSize) size--

        if (head == tail) {
            head = null
            tail = null
            return
        }

        val newTail = tail!!.prev
        newTail?.next = null
        if (shrinkSize) tail!!.inList = false
        tail = newTail
    }

    private var head: Node? = null //newest
    private var tail: Node? = null //oldest
    var size = 0

    private val map = HashMap<Int, Node>()

    fun get(key: Int): Int {
        val node = map[key]
        return if (node?.inList == true) {
            node.moveToListHead()
            node.value
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        if (map[key]?.inList==true) {
            val node = map[key]!!
            node.value = value
            node.moveToListHead()
        } else {
            val node = Node(value)
            map[key] = node
            node.insertToListHead()
            if (size > capacity) {
                removeTailNode()
            }
        }
    }
}