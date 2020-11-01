package Weekly_Contest_213.Count_Sorted_Vowel_Strings

// https://leetcode.com/contest/weekly-contest-213/problems/count-sorted-vowel-strings/
class Solution {
    fun countVowelStrings(n: Int): Int {
        cache = Array(5) { IntArray(n) { -1 } }
        var result = 0
        for (cThis in 0..4) {
            result += step(cThis, n - 1)
        }
        return result
    }

    lateinit var cache: Array<IntArray>

    // 0,1,2,3,4
    fun step(cBefore: Int, n: Int): Int {
        if (n == 0) return 1
        if (cBefore == 4) return 1
        if (cache[cBefore][n] != -1) return cache[cBefore][n]

        var result = 0
        for (cThis in cBefore..4) {
            result += step(cThis, n - 1)
        }
        cache[cBefore][n] = result
        return result
    }
}
