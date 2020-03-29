package Weekly_Contest_182.Count_Number_of_Teams

//https://leetcode.com/contest/weekly-contest-182/problems/count-number-of-teams/
class Solution {
    fun numTeams(rating: IntArray): Int {
        val list = rating.toList()
        step(list,null,null,null)
        return count
    }

    var count = 0
    fun step(list: List<Int>, a: Int?, b: Int?, c: Int?) {
        if (a == null) {
            if (list.size >= 3) {
                repeat(list.size - 2) { i ->
                    step(list.subList(i + 1, list.size), list[i], null, null)
                }
            }
        } else if (b == null) {
            if (list.size >= 2) {
                repeat(list.size - 1) { i ->
                    step(list.subList(i + 1, list.size), a, list[i], null)
                }
            }
        } else if (c == null) {
            repeat(list.size) { i ->
                val newC = list[i]
                if ((a > b && b > newC) || (a < b && b < newC)) {
                    count++
                }
            }
        }
    }
}