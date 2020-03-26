package Hash_Table.Isomorphic_Strings

//https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = hashMapOf<Char, Char>()
        if (s.length != t.length) return false

        repeat(s.length) { i ->
            val sChar = s[i]
            val tChar = t[i]

            val hasS=sChar in map.keys
            val hasT=tChar in map.values

            if (hasS && hasT) {
                if (tChar != map[sChar]) return false
            } else if (!hasS && !hasT) {
                map[sChar] = tChar
            }else{
                return false
            }
        }

        return true
    }
}