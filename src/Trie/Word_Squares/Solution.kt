package Trie.Word_Squares

import java.util.*

//https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1055/
class Solution {
    private class WordSquare {
        constructor(size: Int, firstWord: String) {
            this.size = size
            data = arrayListOf()
            data.add(firstWord)
        }

        constructor(size: Int, data: ArrayList<String>) {
            this.size = size
            this.data = data
        }

        var size = 0
        val data: ArrayList<String>

        fun insert(str: String) {
            data.add(str)
        }

        fun nextWordPrefix(): CharArray {
            return CharArray(data.size) { i ->
                data[i][data.size]
            }
        }

        fun isComplete() = data.size == size

        fun clone() = WordSquare(size, data.clone() as ArrayList<String>)
    }

    private data class Node(var word: String? = null) : HashMap<Char, Node>()

    private val root = Node()

    fun insert(word: String) {
        var curr = root
        word.forEach { char ->
            val node = curr[char] ?: Node()
            curr[char] = node
            curr = node
        }
        curr.word = word
    }

    fun getAll(prefix: CharArray): List<String> {
        var curr: Node? = root
        prefix.forEach { char ->
            curr = curr?.get(char)
        }
        curr ?: return emptyList()

        val queue: Queue<Node> = LinkedList()
        queue.add(curr)

        while (queue.isNotEmpty() && queue.peek().word == null) {
            repeat(queue.size) {
                queue.poll().forEach { char, node ->
                    queue.offer(node)
                }
            }
        }

        return queue.map { it.word!! }
    }

    fun wordSquares(words: Array<String>): List<List<String>> {
        val size = words[0].length
        words.forEach { insert(it) }

        val queue: Queue<WordSquare> = LinkedList()
        words.forEach { str ->
            queue.offer(WordSquare(size, str))
        }

        repeat(size - 1) {
            repeat(queue.size) {
                val ws = queue.poll()
                getAll(ws.nextWordPrefix()).forEach { str ->
                    queue.add(ws.clone().apply { insert(str) })
                }
            }
        }

        return queue.map { it.data }
    }
}