package Array_and_String.Pascals_Triangle

//https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val outerList = arrayListOf<List<Int>>()

        repeat(numRows) { listI ->
            if (listI == 0) {
                outerList.add(listOf(1))
                return@repeat
            }
            val lastList = outerList.last()
            val thisList = arrayListOf<Int>()
            repeat(listI + 1) { i ->
                when (i) {
                    0 -> thisList.add(1)
                    listI -> thisList.add(1)
                    else -> thisList.add(lastList[i - 1] + lastList[i])
                }
            }
            outerList.add(thisList)
        }

        return outerList
    }
}