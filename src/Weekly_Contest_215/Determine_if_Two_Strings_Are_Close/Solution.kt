package Weekly_Contest_215.Determine_if_Two_Strings_Are_Close

// https://leetcode.com/contest/weekly-contest-215/problems/determine-if-two-strings-are-close/
class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val map1 = IntArray(26)
        val map2 = IntArray(26)

        word1.forEach { c ->
            map1[c - 'a']++
        }
        word2.forEach { c ->
            map2[c - 'a']++
        }

        for (i in 0..25) {
            if ((map1[i] == 0) != (map2[i] == 0)) return false
        }

        map1.sort()
        map2.sort()

        for (i in 0..25) {
            if (map1[i] != map2[i]) return false
        }

        return true
    }
}
