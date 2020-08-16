package Weekly_Contest_202.a

// https://leetcode.com/contest/weekly-contest-202/problems/three-consecutive-odds/
class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        if (arr.size < 3) return false
        var a = arr[0].isOdd()
        var b = arr[1].isOdd()
        var c = arr[2].isOdd()

        for (i in 1..(arr.size - 3)) {
            if (a && b && c) return true
            a = b
            b = c
            c = arr[i + 2].isOdd()
        }

        return a && b && c
    }

    fun Int.isOdd() = this % 2 == 1
}
