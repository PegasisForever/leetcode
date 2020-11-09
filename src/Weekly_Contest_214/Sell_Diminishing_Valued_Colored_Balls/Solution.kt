package c

fun main() {
    println(Solution().maxProfit(intArrayOf(2, 4, 6), 10))
}

// https://leetcode.com/problems/sell-diminishing-valued-colored-balls/
class Solution {
    fun maxProfit(inventory: IntArray, orders: Int): Int {
        var total = 0L
        inventory.forEach { count ->
            total += count
        }
        var removing = total - orders

        inventory.sort()
        val levels = LongArray(inventory.size)
        val levelHeight = IntArray(inventory.size)
        for (i in inventory.indices) {
            if (i == 0) {
                val height = inventory[i]
                levelHeight[i] = height
                levels[i] = height.toLong() * (inventory.size - i)
            } else {
                val height = inventory[i] - inventory[i - 1]
                levelHeight[i] = height
                levels[i] = height.toLong() * (inventory.size - i)
            }
        }

        var levelRest = 0L
        var level = 0
        for (i in levels.indices) {
            val levelTotal = levels[i]
            if (removing > levelTotal) {
                removing -= levelTotal
            } else {
                levelRest = levelTotal - removing
                level = i
                break
            }
        }

        var profit = 0L
        for (i in (level + 1)..inventory.lastIndex) {
            val height = levelHeight[i]
            val start = inventory[i - 1]
            val end = start + height
            profit += (start + 1 + end).toLong() * (end - (start + 1) + 1) / 2 * (inventory.size - i)
        }

        if (levelRest != 0L) {
            val width = inventory.size - level
            val height = levelRest / width
            val end = inventory[level]
            val start = end - height
            profit += ((start + 1) + end) * (end - (start + 1) + 1) / 2 * (inventory.size - level)

            profit += (start) * (levelRest % width)
        }


        return (profit % 1000000007).toInt()
    }
}
