package Binary_Search_Tree.Kth_Largest_Element_in_a_Stream

import java.util.*

//undone
class KthLargest(val k: Int, nums: IntArray) {
    val queue: Queue<Int> = LinkedList()

    init {
        nums.forEach { add(it) }
    }

    fun add(value: Int): Int {
        queue.add(value)
        if (queue.size > k) queue.poll()
        return queue.max()!!
    }
}