package Array_and_String.Pascals_Triangle_2

fun main() {
    Solution().getRow(3)
}

//https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1171/
class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val row = arrayListOf(1)
        repeat(rowIndex) { i ->
            row.add(1)
            for (j in i downTo 1){
                row[j] += row[j-1]
            }
        }

        return row
    }
}