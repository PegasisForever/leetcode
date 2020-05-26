package Weekly_Contest_189.Number_of_Students_Doing_Homework_at_a_Given_Time

//https://leetcode.com/contest/weekly-contest-189/problems/number-of-students-doing-homework-at-a-given-time/
class Solution {
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var count = 0
        repeat(startTime.size) { i ->
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) count++
        }
        return count
    }
}
