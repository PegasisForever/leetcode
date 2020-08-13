package Weekly_Contest_199.a

class Solution {
    fun restoreString(s: String, indices: IntArray): String {
        val result = CharArray(s.length)
        repeat(s.length) { i ->
            result[indices[i]] = s[i]
        }

        return result.joinToString("")
    }
}
