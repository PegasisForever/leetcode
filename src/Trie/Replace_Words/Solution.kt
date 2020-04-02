package Trie.Replace_Words

//https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1053/
class Solution {
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

    fun replaceWords(dict: List<String>, sentence: String): String {
        dict.forEach {
            if (it.isEmpty()) {
                return ""
            } else {
                insert(it)
            }
        }
        return sentence
            .split(" ")
            .map { word ->
                var curr = root
                var length = 0
                word.forEach { char ->
                    if (char in curr) {
                        curr = curr[char]!!
                        length++
                        if (curr.hasWord) return@map word.substring(0 until length)
                    } else {
                        return@map word
                    }
                }
                word
            }
            .joinToString(" ")
    }
}