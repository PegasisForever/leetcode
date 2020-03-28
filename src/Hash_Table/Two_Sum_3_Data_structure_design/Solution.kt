package Hash_Table.Two_Sum_3_Data_structure_design

//https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1179/
class TwoSum {
    private val numbers = HashMap<Int, Int>()

    fun add(number: Int) {
        numbers[number] = (numbers[number] ?: 0) + 1
    }

    fun find(target: Int): Boolean {
        numbers.keys.forEach { num ->
            val anotherNum = target - num
            if (numbers[anotherNum] != null) {
                if (anotherNum != num) {
                    return true
                } else if (anotherNum == num && numbers[anotherNum]!! >= 2) {
                    return true
                }
            }
        }

        return false
    }
}