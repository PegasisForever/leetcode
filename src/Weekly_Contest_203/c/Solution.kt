package Weekly_Contest_203.c

// timeout
class Solution {
    fun IntRange.length() = last - first + 1

    fun findLatestStep(arr: IntArray, m: Int): Int {
        if (m == arr.size) return m
        val totalRange = arr.indices
        val rangeArr = Array<IntRange?>(arr.size) { totalRange }

        for (arrI in arr.lastIndex downTo 1) {
            val i = arr[arrI] - 1
            val currRange = rangeArr[i]!!
            rangeArr[i] = null

            val pre = currRange.first until i
            val post = (i + 1)..currRange.last

            if (pre.length() == m || post.length() == m) {
                return arrI
            }

            for (j in pre) {
                rangeArr[j] = pre
            }
            for (j in post) {
                rangeArr[j] = post
            }
        }

        return -1
    }
}
