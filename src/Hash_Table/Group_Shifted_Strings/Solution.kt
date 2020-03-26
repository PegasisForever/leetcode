package Hash_Table.Group_Shifted_Strings

class Solution {
    fun difference(a: Int, b: Int) = if (b >= a) {
        b - a
    } else {
        b - (a - 26)
    }

    fun String.hash(): Int {
        if (this.isEmpty()) return -1
        val charArray = this.toCharArray()
        var sum = 0
        var power = 1
        repeat(charArray.size - 1) { i ->
            power *= 31
            val difference = difference(this[i].toInt(), this[i + 1].toInt()) + 1
            sum += difference * power
        }
        return sum
    }

    fun groupStrings(strings: Array<String>): List<List<String>> {
        val map = hashMapOf<Int, ArrayList<String>>()
        strings.forEach { str ->
            val hash = str.hash()
            if (hash in map) {
                map[hash]!!.add(str)
            } else {
                map[hash] = arrayListOf(str)
            }
        }
        return map.values.toList()
    }
}