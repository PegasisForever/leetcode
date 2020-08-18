package Greedy.Delete_Columns_to_Make_Sorted

// https://leetcode.com/problems/delete-columns-to-make-sorted/
class Solution {
    fun minDeletionSize(arr: Array<String>): Int {
        var count = 0
        out@ for (i in arr[0].indices) {
            var lastChar = 'a'
            for (j in arr.indices) {
                if (arr[j][i] < lastChar) {
                    count++
                    continue@out
                } else {
                    lastChar = arr[j][i]
                }
            }
        }

        return count
    }
}
