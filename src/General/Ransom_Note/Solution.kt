package General.Ransom_Note

//https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
class Solution {
    fun String.toMap(): HashMap<Char, Int> {
        val map = hashMapOf<Char, Int>()
        forEach { char ->
            map[char] = (map[char] ?: 0) + 1
        }
        return map
    }

    fun contains(map1: HashMap<Char, Int>, map2: HashMap<Char, Int>): Boolean {
        for (i in 0..25) {
            if (map1[(i + 97).toChar()] ?: 0 > map2[(i + 97).toChar()] ?: 0) return false
        }
        return true
    }

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map1 = ransomNote.toMap()
        val map2 = magazine.toMap()
        return contains(map1, map2)
    }
}