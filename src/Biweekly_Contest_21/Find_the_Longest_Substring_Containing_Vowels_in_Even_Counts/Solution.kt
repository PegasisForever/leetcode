package Biweekly_Contest_21.b

import kotlin.math.max

fun main() {
    Solution().findTheLongestSubstring("leetcodeisgreat")
}

//https://leetcode.com/contest/biweekly-contest-21/problems/find-the-longest-substring-containing-vowels-in-even-counts/
class Solution {
    //false:single true:double
    data class State(
        val a: Boolean,
        val e: Boolean,
        val i: Boolean,
        val o: Boolean,
        val u: Boolean
    )

    fun findTheLongestSubstring(s: String): Int {
        val map = hashMapOf<State, Int>()
        var state = State(true, true, true, true, true)
        map[state] = -1
        var maxLength = 0

        s.forEachIndexed { index, c ->
            state = when (c) {
                'a' -> state.copy(a = !state.a)
                'e' -> state.copy(e = !state.e)
                'i' -> state.copy(i = !state.i)
                'o' -> state.copy(o = !state.o)
                'u' -> state.copy(u = !state.u)
                else -> state
            }

            if (state !in map) {
                map[state] = index
            } else {
                maxLength = max(maxLength, index - map[state]!!)
            }
        }

        return maxLength

    }
}