package General.Bitwise_AND_of_Numbers_Range

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3308/
class Solution {
    fun Int.toBitArray(): BooleanArray {
        return BooleanArray(31) { i ->
            ((this shr (30 - i)) and 1) == 1
        }
    }

    fun BooleanArray.toInt(): Int {
        if (this.size != 31) error("Array length must equal 31.")
        var result = 0
        repeat(31) { i ->
            result += (if (this[i]) 1 else 0) shl (30 - i)
        }
        return result
    }

    infix fun BooleanArray.and(other: BooleanArray): BooleanArray {
        val resultLength = maxOf(this.size, other.size)
        val thisOffset = this.size - resultLength
        val otherOffset = other.size - resultLength
        return BooleanArray(resultLength) { i ->
            (this.getOrNull(i + thisOffset) ?: false) &&
                    (other.getOrNull(i + otherOffset) ?: false)
        }
    }

    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        val mArr = m.toBitArray()
        val nArr = n.toBitArray()
        val result = mArr and nArr

        for (i in 0 until 31) {
            if (mArr[i] != nArr[i]) {
                for (ii in i until 31) {
                    result[ii] = false
                }
                break
            }
        }

        return result.toInt()
    }
}