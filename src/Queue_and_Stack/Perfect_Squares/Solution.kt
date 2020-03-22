package Queue_and_Stack.Perfect_Squares

fun main() {
    println(Solution().numSquares(4))
}

//https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/
class Solution {
    var target = 0
    fun numSquares(target: Int): Int {
        this.target = target

        var base = 1
        while (base.square() <= target) base++

        count(base - 1) {
            if (it.isTarget()) return it.size
        }

        error("wtf")
    }

    fun ArrayList<Int>.isTarget(): Boolean {
        var sum = 0
        forEach {
            sum += (it + 1).square()
            if (sum > target) return false
        }
        return sum == target
    }

    fun Int.square() = this * this
}

inline fun count(base: Int, action: (ArrayList<Int>) -> Unit) {
    if (base == 1) {
        val nums = arrayListOf(0)
        while (true) {
            action(nums)
            nums.add(0)
        }
    } else {
        val nums = arrayListOf(0)
        while (true) {
            action(nums)
            nums[0]++

            var cursor = 0
            while (nums[cursor] >= base) {
                nums[cursor] = 0
                if (cursor + 1 == nums.size) nums.add(0)
                nums[cursor + 1]++
                cursor++
            }
        }
    }
}