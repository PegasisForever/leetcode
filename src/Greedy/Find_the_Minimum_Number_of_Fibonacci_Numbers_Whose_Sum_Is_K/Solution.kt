package Greedy.Find_the_Minimum_Number_of_Fibonacci_Numbers_Whose_Sum_Is_K

// https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
class Solution {
    fun findMinFibonacciNumbers(k: Int): Int {
        val fib = arrayListOf(1, 1)
        while (fib.last() < k) {
            fib.add(fib.last() + fib[fib.lastIndex - 1])
        }

        var count = 0
        var num = 0
        var fibI = fib.lastIndex
        while (num < k) {
            if (num + fib[fibI] <= k) {
                num += fib[fibI]
                count++
            }
            fibI--
        }
        return count
    }
}
