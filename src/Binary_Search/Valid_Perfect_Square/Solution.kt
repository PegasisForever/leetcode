package Binary_Search.Valid_Perfect_Square

//https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/
class Solution {
    // from: include  to: include  getCompareResult: return is given int too large?(+1)
    inline fun binaryFindExact(from: Int, to: Int, getCompareResult: (Int) -> Int): Int? {
        var left = from
        var right = to

        while (true) {
            val mid = left + (right - left) / 2
            val com = getCompareResult(mid)

            when {
                com == 0 -> return mid
                com > 0 -> right = mid - 1
                else -> left = mid + 1
            }
            if (right < left) return null
        }
    }


    fun isPerfectSquare(num: Int): Boolean {
        return binaryFindExact(1, num) {
            if (it > 46340) return@binaryFindExact 1
            it * it - num
        } != null
    }
}
