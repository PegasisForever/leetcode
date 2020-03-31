package Trie.Map_Sum_Pairs

//https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1058/
class MapSum {
    private data class Node(var value: Int = 0) : HashMap<Char, Node>() {
        fun sum(): Int {
            var sum = value
            values.forEach { sum += it.sum() }
            return sum
        }
    }

    private val root = Node()

    fun insert(key: String, value: Int) {
        var curr = root
        key.forEach { char ->
            val node = curr[char] ?: Node()
            curr[char] = node
            curr = node
        }
        curr.value = value
    }

    fun sum(prefix: String): Int {
        var curr = root
        prefix.forEach { char ->
            if (char in curr) {
                curr = curr[char]!!
            } else {
                return 0
            }
        }

        return curr.sum()
    }
}