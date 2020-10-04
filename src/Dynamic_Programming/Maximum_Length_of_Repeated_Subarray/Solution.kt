package Dynamic_Programming.Maximum_Length_of_Repeated_Subarray

import println

fun main() {
    Solution().findLength(
        intArrayOf(0, 1, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1)
    ).println()
}

class Solution {
    data class TwoCell(var t: Int = -1, var f: Int = -1) {
        operator fun get(b: Boolean): Int = if (b) {
            t
        } else {
            f
        }

        operator fun set(b: Boolean, value: Int) {
            if (b) {
                t = value
            } else {
                f = value
            }
        }
    }

    fun findLength(arrA: IntArray, arrB: IntArray): Int {
        cache = Array(arrA.size) { Array(arrB.size) { TwoCell() } }
        this.arrA = arrA
        this.arrB = arrB

        return step(0, 0)
    }

    lateinit var cache: Array<Array<TwoCell>>
    lateinit var arrA: IntArray
    lateinit var arrB: IntArray

    fun step(aI: Int, bI: Int, allowSkip: Boolean = true): Int {
        if (aI >= arrA.size || bI >= arrB.size) return 0
        if (cache[aI][bI][allowSkip] != -1) return cache[aI][bI][allowSkip]

        return if (!allowSkip) {
            if (arrA[aI] == arrB[bI]) {
                var aJ=aI+1
                var bJ=bI+1
                while (arrA[aJ] == arrB[bJ]){
                    cache[aJ][bJ][false]=
                    aJ++
                    bJ++
                }
                step(aI + 1, bI + 1, false) + 1
            } else {
                0
            }
        } else if (arrA[aI] == arrB[bI]) {
            maxOf(
                step(aI + 1, bI + 1, false) + 1,
                step(aI + 1, bI),
                step(aI, bI + 1)
            )
        } else {
            maxOf(step(aI + 1, bI), step(aI, bI + 1))
        }.also {
            cache[aI][bI][allowSkip] = it
        }
    }
}
