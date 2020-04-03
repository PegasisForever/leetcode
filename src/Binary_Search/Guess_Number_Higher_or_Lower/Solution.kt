package Binary_Search.Guess_Number_Higher_or_Lower

open class GuessGame {
    fun guess(num: Int): Int = TODO()
    open fun guessNumber(n: Int): Int = TODO()
}

class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        var left = 1
        var right = n
        while (left <= right) {
            val mid = left + (right - left) / 2
            when (guess(mid)) {
                -1 -> right = mid - 1
                1 -> left = mid + 1
                0 -> return mid
            }
        }
        error("wtf")
    }
}