package Dynamic_Programming.Is_Subsequence

//https://leetcode.com/problems/is-subsequence/
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.length > t.length) return false
        var sPtr = 0
        var tPtr = 0
        while (true) {
            if (sPtr == s.length) return true
            if (tPtr == t.length) return false
            if (s[sPtr] == t[tPtr]) {
                sPtr++
                tPtr++
            } else {
                tPtr++
            }
        }
    }
}