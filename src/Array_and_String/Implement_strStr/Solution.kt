package Array_and_String.Implement_strStr

fun main() {
    println(Solution().strStr("aabb","abb"))
}

//https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle == "") return 0
        if (needle.length > haystack.length) return -1

        val targetHash = RollingHasher(needle).hash
        val windowSize = needle.length
        val rollingHasher = RollingHasher(haystack.substring(0, windowSize))

        repeat(haystack.length - windowSize) { i ->
            if (rollingHasher.hash == targetHash) return i
            rollingHasher.update(haystack[i], haystack[i + windowSize])
        }

        return if (rollingHasher.hash == targetHash) haystack.length - windowSize else -1
    }
}

//https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
class RollingHasher(initString: String) {
    var hash = 0
    private var bToN = 1

    init {
        val windowSize = initString.length
        repeat(windowSize) {
            bToN *= 31
        }
        initString.forEach { char ->
            hash = 31 * hash + char.hashCode()
        }
    }

    fun update(outChar: Char, inChar: Char): Int {
        hash = 31 * hash + inChar.hashCode() - bToN * outChar.hashCode()
        return hash
    }
}