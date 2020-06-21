package Binary_Search.Binary_Search

//https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
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

    fun search(nums: IntArray, target: Int): Int {
        return binaryFindExact(0, nums.lastIndex) {
            nums[it] - target
        } ?: -1
    }
}
