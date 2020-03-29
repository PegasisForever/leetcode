package Weekly_Contest_182.Find_Lucky_Integer_in_an_Array

//https://leetcode.com/contest/weekly-contest-182/problems/find-lucky-integer-in-an-array/
class Solution {
    fun findLucky(arr: IntArray): Int {
        val hashTable = HashMap<Int, Int>()
        arr.forEach { num ->
            hashTable[num] = (hashTable[num] ?: 0) + 1
        }

        var max = -1
        hashTable.forEach { num, f ->
            if (num == f) {
                max = maxOf(num, max)
            }
        }
        return max
    }
}