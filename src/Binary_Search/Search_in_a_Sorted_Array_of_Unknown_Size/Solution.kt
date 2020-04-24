package Binary_Search.Search_in_a_Sorted_Array_of_Unknown_Size

interface ArrayReader {
    fun get(index: Int): Int
}

//https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/1061/
class Solution {
    fun search(reader: ArrayReader, target: Int): Int {
        if (target > 9999 || target < -9999 || reader.get(0) > 9999) return -1
        var left = 0
        var right = Int.MAX_VALUE
        while (true) {
            val mid = left + (right - left) / 2
            val num = reader.get(mid)

            if (num == target) return mid
            if (num > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
            if (right < left) return -1
        }
    }
}