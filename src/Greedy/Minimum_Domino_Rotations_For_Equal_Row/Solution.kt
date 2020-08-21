package Greedy.Minimum_Domino_Rotations_For_Equal_Row

// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
class Solution {
    fun minDominoRotations(A: IntArray, B: IntArray): Int {
        val a = minR(A, B)

        val temp = A.first()
        A[0] = B.first()
        B[0] = temp
        val b = minR(B, A) + 1

        return when {
            a >= 0 && b >= 0 -> minOf(a, b)
            a >= 0 -> a
            b >= 0 -> b
            else -> -1
        }
    }

    fun minR(a: IntArray, b: IntArray): Int {
        val aBase = a.first()
        val bBase = b.first()
        var aSwap = 0
        var bSwap = 0
        for (i in 1 until a.size) {
            if (aSwap < 0 && bSwap < 0) return -2
            if (b[i] == aBase && a[i] != aBase) {
                aSwap++
            } else if (b[i] != aBase && a[i] != aBase) {
                aSwap = Int.MIN_VALUE
            }
            if (a[i] == bBase && b[i] != bBase) {
                bSwap++
            } else if (a[i] != bBase && b[i] != bBase) {
                bSwap = Int.MIN_VALUE
            }
        }

        return when {
            aSwap >= 0 && bSwap >= 0 -> intArrayOf(aSwap, bSwap, a.size - aSwap, b.size - bSwap).min()!!
            aSwap >= 0 -> minOf(aSwap, a.size - aSwap)
            bSwap >= 0 -> minOf(bSwap, b.size - bSwap)
            else -> -2
        }
    }
}
