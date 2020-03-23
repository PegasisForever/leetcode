package Queue_and_Stack.Daily_Temperatures

fun main() {
    with(Solution()) {
    }
}

//timeout
class Solution {
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
class Solution2 {
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