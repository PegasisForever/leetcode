package Binary_Search.First_Bad_Version

fun main() {
    Solution().firstBadVersion(5)
}

abstract class VersionControl {
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(version: Int): Boolean = version >= 4
}

//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/
class Solution : VersionControl() {
    // from: include  to: include
    inline fun binaryFindFirst(from: Int, to: Int, action: (Int) -> Boolean): Int? {
        var left = from
        var right = to
        var mid: Int
        while (left < right) {
            mid = left + (right - left) / 2
            if (action(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return if (left == to) {
            if (action(to)) {
                to
            } else {
                null
            }
        } else {
            left
        }
    }

    override fun firstBadVersion(n: Int): Int {
        return binaryFindFirst(1, n, this::isBadVersion)!!
    }
}
