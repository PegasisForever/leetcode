package Weekly_Contest_203.c

// timeout
class Solution {
    fun findLatestStep(arr: IntArray, m: Int): Int {
        var res = -1
        val n: Int = arr.size
        val length = IntArray(n + 2)
        val count = IntArray(n + 1)
        for (i in 0 until n) {
            val a: Int = arr[i]
            val left = length[a - 1]
            val right = length[a + 1]
            length[a + right] = left + right + 1
            length[a - left] = length[a + right]
            length[a] = length[a - left]
            count[left]--
            count[right]--
            count[length[a]]++
            if (count[m] > 0) res = i + 1
        }
        return res
    }
}
