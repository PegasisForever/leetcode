package General.First_Unique_Number


//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
class FirstUnique(nums: IntArray) {
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

        fun remove() {
            if (size == 1) {
                head = null
                tail = null
            } else if (prev == null) {
                head = this.next
                head?.prev = null
            } else if (next == null) {
                removeTailNode(false)
            } else {
                prev!!.next = next
                next!!.prev = prev
            }
            inList = false
            size--
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

    init {
        nums.forEach { add(it) }
    }

    fun showFirstUnique(): Int {
        return tail?.value ?: -1
    }

    fun add(value: Int) {
        if (map[value]?.inList == true) {
            val node = map[value]!!
            node.remove()
            node.inList = false
        } else if (value !in map) {
            val node = Node(value)
            map[value] = node
            node.insertToListHead()
        }
    }
}