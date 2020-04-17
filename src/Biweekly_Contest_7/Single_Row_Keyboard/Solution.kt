package Biweekly_Contest_7.a

import kotlin.math.abs

//https://leetcode.com/contest/biweekly-contest-7/problems/single-row-keyboard/
class Solution {
    fun calculateTime(keyboard: String, word: String): Int {
        val indexMap = hashMapOf<Char, Int>()
        keyboard.forEachIndexed { index, c ->
            indexMap[c] = index
        }

        var result = 0
        var lastPos = 0
        word.forEach { char ->
            val pos = indexMap[char]!!
            result += abs(pos - lastPos)
            lastPos = pos
        }
        return result
    }
}