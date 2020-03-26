package Hash_Table.Design_HashMap

import java.util.*

//https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1140/
class MyHashMap {
    data class Item(var key: Int, var value: Int)

    private val buckets = arrayOfNulls<LinkedList<Item>>(1000)

    private fun Int.getBucket() = if (buckets[this % 1000] == null) {
        val newBucket = LinkedList<Item>()
        buckets[this % 1000] = newBucket
        newBucket
    } else {
        buckets[this % 1000]!!
    }

    fun put(key: Int, value: Int) {
        val bucket = key.getBucket()
        val existingItem = bucket.find { it.key == key }
        if (existingItem != null) {
            existingItem.value = value
        } else {
            val item = Item(key, value)
            bucket += item
        }
    }

    fun get(key: Int): Int {
        val bucket = key.getBucket()
        val existingItem = bucket.find { it.key == key }
        return existingItem?.value ?: -1
    }

    fun remove(key: Int) {
        val bucket = key.getBucket()
        bucket.removeIf { it.key == key }
    }

}