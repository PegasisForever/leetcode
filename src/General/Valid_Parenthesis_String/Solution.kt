package General.Valid_Parenthesis_String

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3301/
class Solution {
    fun checkValidString(s: String): Boolean {
        this.s = s.toCharArray()
        return step(0, 0)
    }

    lateinit var s: CharArray

    fun step(extraLeft: Int, index: Int): Boolean {
        if (index == s.size) return extraLeft == 0
        if (extraLeft < 0) return false

        return when (s[index]) {
            '(' -> step(extraLeft + 1, index + 1)
            ')' -> step(extraLeft - 1, index + 1)
            '*' -> step(extraLeft, index + 1) ||
                    step(extraLeft + 1, index + 1) ||
                    step(extraLeft - 1, index + 1)

            else -> error("wtf")
        }
    }
}