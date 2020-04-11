package General.Backspace_String_Compare

fun main() {
    Solution().backspaceCompare("xywrrmp","xywrrmu#p")
}

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/
class Solution {
    fun backspaceCompare(S: String, T: String): Boolean {
        if (S.isEmpty() && T.isEmpty()) return true
        if (S.isEmpty() xor T.isEmpty()) return false

        var sPtr = S.lastIndex
        var tPtr = T.lastIndex

        while (true) {
            val (nextSPtr, sChar) = nextChar(S, sPtr)
            val (nextTPtr, tChar) = nextChar(T, tPtr)

            if (sChar != tChar) {
                return false
            } else if (nextSPtr == -1 && nextTPtr == -1) {
                return true
            } else {
                sPtr = nextSPtr
                tPtr = nextTPtr
            }
        }
    }

    fun nextChar(str: String, startIndex: Int): Pair<Int, Char?> {
        var backspaces = 0
        var i = startIndex
        while (i >= 0) {
            when (str[i]) {
                '#' -> backspaces++
                else -> if (backspaces > 0) {
                    backspaces--
                } else {
                    return i - 1 to str[i]
                }
            }
            i--
        }

        return -1 to null
    }
}