package Weekly_Contest_186.b

//https://leetcode.com/contest/weekly-contest-186/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var points = 0
        repeat(k) { points += cardPoints[it] }

        var result = points

        repeat(k) { i ->
            points += cardPoints[cardPoints.lastIndex - i] - cardPoints[k - i - 1]
            result = maxOf(result, points)
        }

        return result
    }
}