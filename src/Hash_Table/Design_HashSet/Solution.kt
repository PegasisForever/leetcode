package Hash_Table.Design_HashSet

import java.util.*

//https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139/
class MyHashSet {
    private val buckets = arrayOfNulls<LinkedList<Int>>(1000)

    private fun Int.getBucket() = if (buckets[this % 1000] == null) {
        val newBucket = LinkedList<Int>()
        buckets[this % 1000] = newBucket
        newBucket
    } else {
        buckets[this % 1000]!!
    }

    fun add(key: Int) {
        val bucket = key.getBucket()
        if (key !in bucket) {
            bucket += key
        }
    }

    fun remove(key: Int) {
        val bucket = key.getBucket()
        bucket.remove(key)
    }

    fun contains(key: Int): Boolean {
        val bucket = key.getBucket()
        return key in bucket
    }
}