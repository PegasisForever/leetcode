package Queue_and_Stack.Daily_Temperatures

import java.util.*

fun main() {
    with(Solution()) {
        println(dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).joinToString())
    }
}

//https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
class Solution {
    fun dailyTemperatures(temps: IntArray): IntArray {
        val stack = Stack<Int>()
        val result = IntArray(temps.size)
        for (i in temps.lastIndex downTo 0) {
            val temp = temps[i]
            while (stack.isNotEmpty() && temps[stack.peek()] <= temp) stack.pop()
            if (stack.isNotEmpty()) {
                val lastWarmIndex = stack.peek()
                result[i] = lastWarmIndex - i
            }
            stack.push(i)
        }
        return result
    }
}

//timeout
class Solution2 {
    data class Temperature(val day: Int, val value: Int)

    fun dailyTemperatures(temps: IntArray): IntArray {
        val temperatures = arrayListOf<Temperature>()
        val result = IntArray(temps.size)
        temps.forEachIndexed { day, value ->
            val newTemp = Temperature(day, value)
            temperatures.removeIf { temp ->
                if (temp.value < newTemp.value) {
                    result[temp.day] = newTemp.day - temp.day
                    true
                } else {
                    false
                }
            }
            temperatures.add(newTemp)
        }
        return result
    }
}

//timeout
class Solution3 {
    data class Temperature(val day: Int, val value: Int)

    fun dailyTemperatures(temps: IntArray): IntArray {
        val temperatures = temps
            .mapIndexed { index, value -> Temperature(index, value) }
            .toMutableList()
        val result = IntArray(temperatures.size)

        temperatures.take(temperatures.size).forEach { warmerTemp ->
            temperatures.removeIf { temp ->
                if (temp.day < warmerTemp.day && warmerTemp.value > temp.value) {
                    result[temp.day] = warmerTemp.day - temp.day
                    true
                } else {
                    false
                }
            }
        }

        return result
    }
}