package Weekly_Contest_30.c

fun main() {
    Solution().checkInclusion("ab", "cbac")
}

//https://leetcode.com/contest/leetcode-weekly-contest-30/problems/permutation-in-string/
class Solution {
    fun String.toMap(): HashMap<Char, Int> {
        val map = hashMapOf<Char, Int>()
        forEach { char ->
            map[char] = (map[char] ?: 0) + 1
        }
        return map
    }

    fun same(map1: HashMap<Char, Int>, map2: HashMap<Char, Int>): Boolean {
        for (i in 0..25) {
            if (map1[(i + 97).toChar()] ?: 0 != map2[(i + 97).toChar()] ?: 0) return false
        }
        return true
    }

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val s1l = s1.length
        val s1Map = s1.toMap()

        val s2Map = s2.substring(0..s1.lastIndex).toMap()


        if (same(s1Map, s2Map)) return true
        for (i in s1l..s2.lastIndex) {
            s2Map[s2[i - s1l]] = s2Map[s2[i - s1l]]!! - 1
            s2Map[s2[i]] = (s2Map[s2[i]] ?: 0) + 1
            if (same(s1Map, s2Map)) return true
        }
        return false
    }
}