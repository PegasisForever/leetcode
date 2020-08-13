package Weekly_Contest_200.c

class Solution {
    fun minSwaps(grid: Array<IntArray>): Int {
        // zero count -> [row indexes]
        val trailingZeros = Array<ArrayList<Int>>(grid.size) { ArrayList(1) }
        grid.forEachIndexed { rowIndex, row ->
            for (i in row.lastIndex downTo 0) {
                if (row[i] == 1) {
                    trailingZeros[row.lastIndex - i].add(rowIndex)
                }
            }
        }

        for (i in 1..(grid.size - 1)) {
            if (trailingZeros[i].isEmpty()) return -1
        }

        // newIndex -> oldIndex
        val targetRowIndex = IntArray(grid.size - 1)
        for (newRowIndex in targetRowIndex.indices) {
            val requiredZeros = grid.size - newRowIndex - 1
        }

        TODO()
    }
}
