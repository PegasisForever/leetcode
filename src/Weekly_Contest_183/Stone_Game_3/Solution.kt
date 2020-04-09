package Weekly_Contest_183.Stone_Game_3

import kotlin.math.min

fun main() {
    Solution().stoneGameIII(intArrayOf(-1,-2,-3))
}

//https://leetcode.com/contest/weekly-contest-183/problems/stone-game-iii/
//incorrect
class Solution {
    fun stoneGameIII(stoneValue: IntArray): String {
        var diff = 0
        var list = stoneValue.asList()
        while (list.isNotEmpty()) {
            val (newDiff, step) = maxDifference(list)
            diff += newDiff
            list = list.subList(step, list.size)
        }
        return when {
            diff > 0 -> "Alice"
            diff == 0 -> "Tie"
            else -> "Bob"
        }
    }

    fun maxDifference(list: List<Int>): Pair<Int, Int> {
        var maxD = Int.MIN_VALUE
        var step = 0
        repeat(min(3, list.size)) { aStep ->
            var a = 0
            repeat(aStep + 1) { aI ->
                a += list[aI]
            }

            if (list.size - aStep - 1 == 0) {
                if (a > maxD) {
                    maxD == a
                    step = aStep + 1
                }
                return@repeat
            }
            var bMax = Int.MIN_VALUE
            var bs = 0
            repeat(min(3, list.size - aStep - 1)) { bStep ->
                var newB = 0
                repeat(bStep + 1) { bI ->
                    newB += list[aStep + 1 + bI]
                }

                if (newB > bMax) {
                    bMax = newB
                    bs = bStep + 1
                }
            }
            if (a - bMax > maxD) {
                maxD = a - bMax
                step = aStep + 1 + bs
            }
        }
        return maxD to step
    }
}