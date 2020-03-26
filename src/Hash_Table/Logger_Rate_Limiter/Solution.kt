package Hash_Table.Logger_Rate_Limiter

//https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1122/
class Logger {
    val map = Array<HashSet<String>>(10) { HashSet() }
    var offset = 0

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        var index = timestamp - offset
        if (index > 9) {
            val thisOffset = index - 9
            for (i in 0..9) {
                val newI = i + thisOffset
                if (newI < 10) {
                    map[i] = map[newI]
                }else{
                    map[i]= HashSet()
                }
            }
            offset += thisOffset
            index = 9
        }

        for (i in 0..index) {
            val set = map[i]
            if (message in set) {
                return false
            }
        }
        map[index].add(message)
        return true

    }
}