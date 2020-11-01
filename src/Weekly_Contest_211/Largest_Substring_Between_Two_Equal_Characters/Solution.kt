package Weekly_Contest_211.Largest_Substring_Between_Two_Equal_Characters

fun main() {
    Solution().maxLengthBetweenEqualCharacters("cabbac")
}

class Solution {
    fun maxLengthBetweenEqualCharacters(str: String): Int {
        val firstAppearMap = hashMapOf<Char, Int>()
        str.forEachIndexed { i, char ->
            firstAppearMap[char] = firstAppearMap[char] ?: i
        }

        val lastAppearMap = hashMapOf<Char, Int>()
        str.reversed().forEachIndexed { i, char ->
            lastAppearMap[char] = lastAppearMap[char] ?: (str.length - i - 1)
        }

        var max = -1
        for (char in 'a'..'z') {
            val start = firstAppearMap[char]
            val end = lastAppearMap[char]
            if (start != null && end != null) {
                max = maxOf(max, end - start - 1)
            }
        }
        return max
    }
}
