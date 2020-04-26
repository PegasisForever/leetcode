package Weekly_Contest_186.a

//https://leetcode.com/contest/weekly-contest-186/problems/maximum-score-after-splitting-a-string/
class Solution {
    fun maxScore(s: String): Int {
        var maxScore = 0
        var zeroCount = 0
        s.forEachIndexed { index, char ->
            if (char == '0') zeroCount++
            var oneCount = 0
            for (i in index + 1 until s.length) {
                if (s[i] == '1') oneCount++
            }
            if (index != s.lastIndex) maxScore = maxOf(maxScore, zeroCount + oneCount)
        }
        return maxScore
    }
}