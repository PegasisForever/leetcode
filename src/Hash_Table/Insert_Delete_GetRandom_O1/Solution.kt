package Hash_Table.Insert_Delete_GetRandom_O1

//https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1141/
class RandomizedSet {
    private val buckets = arrayOfNulls<ArrayList<Int>>(1000)
    private val bucketList = ArrayList<ArrayList<Int>>(1000)

    private fun Int.getBucket() = if (buckets[this.toPositive() % 1000] == null) {
        val newBucket = ArrayList<Int>(1)
        buckets[this.toPositive() % 1000] = newBucket
        bucketList.add(newBucket)
        newBucket
    } else {
        buckets[this.toPositive() % 1000]!!
    }

    private fun Int.toPositive() = if (this < 0) -this else this

    fun insert(value: Int): Boolean {
        val bucket = value.getBucket()
        return if (value !in bucket) {
            bucket += value
            true
        } else {
            false
        }
    }

    fun remove(value: Int): Boolean {
        val bucket = value.getBucket()
        return if (value in bucket) {
            if (bucket.size == 1) {
                buckets[value.toPositive() % 1000] = null
                bucketList.remove(bucket)
            } else {
                bucket.remove(value)
            }
            true
        } else {
            if (bucket.isEmpty()) {
                buckets[value.toPositive() % 1000] = null
                bucketList.remove(bucket)
            }
            false
        }

    }

    fun getRandom(): Int {
        return bucketList.random().random()
    }
}
