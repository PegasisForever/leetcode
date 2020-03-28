package Hash_Table.Jewels_and_Stones

//https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1136/
class Solution {
    fun numJewelsInStones(J: String, S: String): Int {
        val map = BooleanArray(58) { false }
        J.forEach { char ->
            map[char.toInt() - 65] = true
        }

        var count = 0
        S.forEach { char ->
            if (map[char.toInt() - 65]) count++
        }

        return count
    }
}