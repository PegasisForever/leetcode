package Hash_Table.Unique_Word_Abbreviation

fun main() {
    val solution = ValidWordAbbr(arrayOf("hello"))
    println(solution.isUnique("hello"))
}

//https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1137/
class ValidWordAbbr(dictionary: Array<String>) {
    private val words = HashSet<String>()
    private val abbrMap = HashMap<String, Int>().apply {
        dictionary.forEach { str ->
            if (str !in words) {
                words += str
                val abbr = str.toAbbr()
                this[abbr] = (this[abbr] ?: 0) + 1
            }
        }
    }

    fun isUnique(word: String): Boolean {
        val abbr = word.toAbbr()
        return if (word !in words) {
            abbr !in abbrMap.keys
        } else {
            abbrMap[abbr]!! == 1
        }
    }

    private fun String.toAbbr(): String {
        if (length <= 2) return this
        return "${this[0]}${length - 2}${this[lastIndex]}"
    }
}