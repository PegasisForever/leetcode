package Trie.Implement_Trie_Prefix_Tree

//https://leetcode.com/explore/learn/card/trie/147/basic-operations/1047/
class Trie {
    private data class Node(var hasWord: Boolean = false) : HashMap<Char, Node>()
    private val root = Node()

    fun insert(word: String) {
        var curr = root
        word.forEach { char ->
            val node = curr[char] ?: Node()
            curr[char] = node
            curr = node
        }
        curr.hasWord = true
    }

    fun search(word: String): Boolean {
        var curr = root
        word.forEach { char ->
            if (char in curr) {
                curr = curr[char]!!
            } else {
                return false
            }
        }
        return curr.hasWord
    }

    fun startsWith(prefix: String): Boolean {
        var curr = root
        prefix.forEach { char ->
            if (char in curr) {
                curr = curr[char]!!
            } else {
                return false
            }
        }
        return true
    }
}