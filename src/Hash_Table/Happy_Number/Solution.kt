package Hash_Table.Happy_Number

fun main() {
    val data = arrayOf(
        1164735054
    )
    val solution = Solution()
    for (d in data) {
        println(solution.isHappy(d))
    }
}

//https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1131/
class Solution {
    fun isHappy(n: Int): Boolean {
        val set = hashSetOf<Int>()
        var curr = n
        while (true) {
            if (curr == 1) return true
            if (curr in set) return false
            set += curr
            curr = curr.digits().squaredSum()
        }
    }

    fun Int.digits(): List<Int> {
        var curr = this
        var base: Long = 10
        val list = arrayListOf<Int>()

        while (curr != 0) {
            val mod = curr % base
            list += (mod / (base / 10)).toInt()
            curr -= mod.toInt()

            base *= 10
        }

        return list
    }

    fun List<Int>.squaredSum(): Int {
        var sum = 0
        this.forEach { num -> sum += num * num }
        return sum
    }
}