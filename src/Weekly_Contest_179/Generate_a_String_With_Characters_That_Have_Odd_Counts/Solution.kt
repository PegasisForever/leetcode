package Weekly_Contest_179.Generate_a_String_With_Characters_That_Have_Odd_Counts

//https://leetcode.com/contest/weekly-contest-179/problems/generate-a-string-with-characters-that-have-odd-counts/
class Solution {
    fun generateTheString(n: Int): String {
        val sb = StringBuilder()
        if (n % 2 == 1) {
            repeat(n) { sb.append('a') }
        } else {
            repeat(n - 1) { sb.append('a') }
            sb.append('b')
        }
        return sb.toString()
    }
}