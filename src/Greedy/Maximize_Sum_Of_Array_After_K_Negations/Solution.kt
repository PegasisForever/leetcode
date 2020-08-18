package Greedy.Maximize_Sum_Of_Array_After_K_Negations

// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
class Solution {
    fun largestSumAfterKNegations(A: IntArray, K: Int): Int {
        A.sort()
        var kLeft = 0
        for (i in 0 until K) {
            if (A[i] < 0) {
                A[i] *= -1
            } else {
                kLeft = K - i
                break
            }
        }
        if (kLeft % 2 == 1) {
            A.sort()
            A[0] *= -1
        }
        return A.sum()
    }
}
