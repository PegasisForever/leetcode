package Weekly_Contest_202.b

// https://leetcode.com/contest/weekly-contest-202/problems/minimum-operations-to-make-array-equal/
class Solution {
    fun minOperations(n: Int): Int {
        if (n == 1) return 0
        if (n % 2 == 1) {
            val count = n / 2
            return runSum(2, 2, count * 2)
        } else {
            val count = n / 2
            return runSum(1, 2, count * 2 - 1)
        }
    }

    fun runSum(start: Int, st: Int, end: Int): Int {
        var sum = 0
        for (i in start..end step st) {
            sum += i
        }
        return sum
    }
}
