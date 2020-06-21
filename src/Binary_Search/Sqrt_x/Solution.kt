package Binary_Search.Sqrt_x

fun main() {
    Solution().mySqrt(2147483647)
}

//https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
class Solution {
    // from: include  to: include
    inline fun binaryFindExact(
        from: Int,
        to: Int,
        getCompareResult: (Int) -> Int
    ): Int? {
        var left = from
        var right = to

        while (true) {
            val mid = (left + right) / 2
            val com = getCompareResult(mid)

            when {
                com == 0 -> return mid
                com > 0 -> right = mid - 1
                else -> left = mid + 1
            }
            if (right < left) return null
        }
    }

    fun mySqrt(x: Int): Int {
        return binaryFindExact(0, minOf(46340, x)) { sqrt ->
            val sqrt = sqrt.toLong()
            if (sqrt * sqrt < x) {
                if ((sqrt + 1) * (sqrt + 1) > x) {
                    0
                } else {
                    -1
                }
            } else if (sqrt * sqrt > x) {
                1
            } else {
                0
            }
        } ?: error("wtf")
    }
}
