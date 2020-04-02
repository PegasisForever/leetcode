package Trie.Palindrome_Pairs

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.set

fun main() {
    println(Solution().palindromePairs(arrayOf("lls", "s")))
}

//https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1138/
class Solution {
    private data class Node(var word: String? = null, var index: Int? = null) : HashMap<Char, Node>()

    private val root = Node()

    private fun insert(word: String, index: Int) {
        var curr = root
        word.forEach { char ->
            val node = curr[char] ?: Node()
            curr[char] = node
            curr = node
        }
        curr.word = word
        curr.index = index
    }

    private fun find(word: String): Int {
        var curr = root
        word.forEach { char ->
            curr = curr[char] ?: return -1
        }
        return curr.index ?: -1
    }

    private fun findStartWith(prefix: String): List<Pair<String, Int>> {
        var curr = root
        prefix.forEach { char ->
            curr = curr[char] ?: return emptyList()
        }
        val result = ArrayList<Pair<String, Int>>()
        val stack = Stack<Node>()
        stack.push(curr)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            node.forEach { (_, nextNode) ->
                if (nextNode.word != null) {
                    result.add(nextNode.word!! to nextNode.index!!)
                }
                stack.push(nextNode)
            }
        }
        return result
    }

    private fun String.isPalin(start: Int = 0, end: Int = this.lastIndex): Boolean {
        repeat((end - start + 1) / 2) { i ->
            if (this[start + i] != this[end - i]) return false
        }
        return true
    }

    fun palindromePairs(words: Array<String>): List<List<Int>> {
        var emptyIndex = -1
        words.forEachIndexed { index, word ->
            if (word.isNotEmpty()) {
                insert(word.reversed(), index)
            } else {
                emptyIndex = index
            }
        }
        val result = ArrayList<List<Int>>()
        if (emptyIndex != -1) {
            words.forEachIndexed { index, word ->
                if (index != emptyIndex && word.isPalin()) {
                    result.add(listOf(emptyIndex, index))
                    result.add(listOf(index, emptyIndex))
                }
            }
        }

        words.forEachIndexed { wordIndex, word ->
            if (wordIndex == emptyIndex) return@forEachIndexed
            repeat(word.length) { i ->
                if (word.isPalin(i + 1, word.lastIndex)) {
                    val anotherIndex = find(word.substring(0..i))
                    if (anotherIndex != -1 && anotherIndex != wordIndex) {
                        result.add(listOf(wordIndex, anotherIndex))
                    }
                }
            }

            val startWithReversed = findStartWith(word)
            startWithReversed.forEach { (another, anotherIndex) ->
                if (another.isPalin(word.length)) {
                    result.add(listOf(wordIndex, anotherIndex))
                }
            }
        }

        return result
    }
}