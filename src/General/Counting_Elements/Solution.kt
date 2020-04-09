package General.Counting_Elements

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
class Solution {
    fun countElements(arr: IntArray): Int {
        val set = HashSet(arr.asList())
        return arr.count { it + 1 in set }
    }
}