package Hash_Table.Group_Anagrams

//https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1124/
class Solution {
    companion object {
        val anaHashMap = IntArray(26).apply {
            var sum = 1
            repeat(26) { i ->
                sum *= 31
                this[i] = sum
            }
        }
    }

    private fun Char.anaHash() = anaHashMap[this.toInt() - 97]

    private fun String.anaHash(): Int {
        var sum = 0
        forEach { char -> sum += char.anaHash() }
        return sum
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<Int, ArrayList<String>>()
        strs.forEach { str ->
            val anaHash = str.anaHash()
            if (anaHash in map) {
                map[anaHash]!!.add(str)
            } else {
                map[anaHash] = arrayListOf(str)
            }
        }
        return map.values.toList()
    }
}