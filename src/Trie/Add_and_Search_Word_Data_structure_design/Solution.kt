package Trie.Add_and_Search_Word_Data_structure_design

import java.util.*

fun main() {
    with(WordDictionary()) {
//        addWord("ran")
//        addWord("rune")
        addWord("runner")
//        addWord("runs")
//        addWord("add")
//        addWord("adds")
//        addWord("adder")
        addWord("addee")
        println(search("....e."))
    }
}

//https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1052/
class WordDictionary {
    private data class Node(var hasWord: Boolean = false) : HashMap<Char, Node>()

    private val root = Node()

    fun addWord(word: String) {
        var curr = root
        word.forEach { char ->
            val next = curr[char] ?: Node()
            curr[char] = next
            curr = next
        }
        curr.hasWord = true
    }

    fun search(word: String): Boolean {
        val queue: Queue<Node> = LinkedList()
        queue.add(root)

        var cursor = 0
        while (queue.isNotEmpty() && cursor < word.length) {
            val currChar = word[cursor]
            cursor++
            repeat(queue.size) {
                val node = queue.poll()
                if (currChar == '.') {
                    if (cursor == word.length && node.let {
                            it.forEach { (_, node) ->
                                if (node.hasWord) return@let true
                            }
                            false
                        }) return true
                    node.forEach { queue.add(it.value) }
                } else {
                    if (currChar in node) {
                        if (cursor == word.length && node[currChar]!!.hasWord) return true
                        queue.add(node[currChar]!!)
                    }
                }
            }
        }
        return false
    }

}