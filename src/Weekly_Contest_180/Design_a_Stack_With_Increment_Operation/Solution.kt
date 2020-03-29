package Weekly_Contest_180.Design_a_Stack_With_Increment_Operation

import kotlin.math.min

class CustomStack(val maxSize: Int) {
    val data = ArrayList<Int>(maxSize)

    fun push(x: Int) {
        if (data.size < maxSize) {
            data.add(x)
        }
    }

    fun pop(): Int {
        return if (data.isEmpty()) {
            -1
        } else {
            val last = data.last()
            data.removeAt(data.lastIndex)
            last
        }
    }

    fun increment(k: Int, value: Int) {
        repeat(min(k, data.size)) { i ->
            data[i] += value
        }
    }

}