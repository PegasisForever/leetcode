package Hash_Table.First_Unique_Character_in_a_String

//https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1120/
class Solution {
    fun firstUniqChar(s: String): Int {
        val map = IntArray(26) { 0 }
        s.forEach { char->
            map[char.toInt()-97]++
        }

        s.forEachIndexed { index, char ->
            if (map[char.toInt()-97]==1) return index
        }

        return -1
    }
}