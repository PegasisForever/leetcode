package Binary_Search.First_Bad_Version

abstract class VersionControl {
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(version: Int): Boolean = TODO()
}

//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/
class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var left = 1
        var right = n
        while (left < right) {
            val mid = left + (right - left) / 2
            if (isBadVersion(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }
}