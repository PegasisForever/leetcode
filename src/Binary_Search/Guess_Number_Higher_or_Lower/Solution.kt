package Binary_Search.Guess_Number_Higher_or_Lower

fun main() {
    Solution().guessNumber(2126753390)
}

open class GuessGame {
    val target = 1702766719
    fun guess(num: Int): Int {
        println("guess: $num")
        return if (num > target) {
            -1
        } else if (num < target) {
            1
        } else {
            0
        }
    }

    open fun guessNumber(n: Int): Int = TODO()
}

class Solution : GuessGame() {
    // from: include  to: include
    inline fun binaryFindExact(from: Int, to: Int, getCompareResult: (Int) -> Int): Int? {
        var left = from
        var right = to

        while (true) {
            val mid = left + (right - left) / 2
            val com = getCompareResult(mid)

            when {
                com == 0 -> return mid
                com > 0 -> right = mid - 1
                else -> left = mid + 1
            }
            if (right < left) return null
        }
    }


    override fun guessNumber(n: Int): Int {
        return binaryFindExact(1, n) {
            -guess(it)
        } ?: error("wtf")
    }
}
