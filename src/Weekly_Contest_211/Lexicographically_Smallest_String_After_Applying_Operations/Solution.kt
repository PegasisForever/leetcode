package Weekly_Contest_211.Lexicographically_Smallest_String_After_Applying_Operations

import println

fun main() {
    Solution().findLexSmallestString("5525", 9, 2).println()
}

class Solution {
    fun IntArray.add(num: Int) {
        repeat(this.size) { i ->
            if (i % 2 == 1) {
                this[i] = (this[i] + num) % 10
            }
        }
    }

    fun IntArray.circleGet(i: Int): Int {
        var index = if (i >= 0) {
            i % size
        } else {
            size + (i % size)
        }
        if (index == size) index = 0
        return get(index)
    }

    // true: r1>r2
    fun compare(str1: IntArray, str2: IntArray, r1: Int, r2: Int): Boolean {
        for (i in str1.indices) {
            val r1Value = str1.circleGet(i + r1)
            val r2Value = str2.circleGet(i + r2)
            if (r1Value > r2Value) {
                return true
            } else if (r1Value < r2Value) {
                return false
            }
        }
        error("wtf")
    }

    fun findSmallestRotate(str: IntArray, num: Int): Int {
        var currRotate = 0
        var minRotate = 0

        currRotate += num
        while (currRotate % str.size != 0) {
            if (compare(str, str, minRotate, currRotate)) {
                minRotate = currRotate
            }
            currRotate += num
        }

        return minRotate % str.size
    }

    fun findLexSmallestString(s: String, add: Int, rotate: Int): String {
        val str = s.toCharArray()
            .map { it.toInt() - 48 }
            .toIntArray()

        var minStr: IntArray? = null
        var minRotate: Int? = null
        val possibleRotations = when (add) {
            in listOf(1, 3, 7, 9) -> 0..9
            in listOf(2, 4, 6, 8) -> listOf(0, 2, 4, 6, 8)
            5 -> listOf(0, 5)
            else -> error("wtf")
        }
        for (a in possibleRotations) {
            val str = str.clone()
            str.add(a)
            val minR = findSmallestRotate(str, rotate)
            if (minStr == null) {
                minStr = str
                minRotate = minR
            } else if (compare(minStr, str, minRotate!!, minR)) {
                minStr = str
                minRotate = minR
            }
        }


        var resultStr = minStr!!.joinToString("") { (it + 48).toChar().toString() }
        repeat(minRotate!!) {
            resultStr = resultStr.last() + resultStr.substring(0, resultStr.length - 1)
        }
        return resultStr
    }
}
