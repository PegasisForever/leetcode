package Weekly_Contest_219.Count_of_Matches_in_Tournament

// https://leetcode.com/contest/weekly-contest-219/problems/count-of-matches-in-tournament/
class Solution {
    fun numberOfMatches(n: Int): Int {
        var teamLeft = n
        var count = 0
        while (teamLeft > 1) {
            if (teamLeft % 2 == 0) {
                teamLeft /= 2
                count += teamLeft
            } else {
                teamLeft = teamLeft / 2 + 1
                count += teamLeft - 1
            }
        }

        return count
    }
}
