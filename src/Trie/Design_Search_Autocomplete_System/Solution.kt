package Trie.Design_Search_Autocomplete_System

import java.util.*
import kotlin.collections.ArrayList

//https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1054/
class AutocompleteSystem(sentences: Array<String>, times: IntArray) {
    private data class Node(var times: Int = 0) : HashMap<Char, Node>()

    private val root = Node()
    private var inputBuffer = LinkedList<Char>()
    private var lastNode: Node? = root

    init {
        sentences.forEachIndexed { index, s ->
            insert(s, times[index])
        }
    }

    private fun insert(word: String, times: Int = 1) {
        var curr = root
        word.forEach { char ->
            val node = curr[char] ?: Node()
            curr[char] = node
            curr = node
        }
        curr.times += times
    }

    private fun findTop3(prefix: String, node: Node): List<String> {
        val heap = PriorityQueue<Pair<String, Int>>(kotlin.Comparator { (s1, f1), (s2, f2) ->
            return@Comparator if (f1 != f2) {
                f1.compareTo(f2)
            } else {
                -s1.compareTo(s2)
            }
        })

        findAll(prefix, node, true).forEach {
            heap.offer(it)
            if (heap.size > 3) heap.poll()
        }
        val list = ArrayList<String>(3)
        repeat(3) {
            heap.poll()?.let { list.add(0, it.first) }
        }
        return list
    }

    private fun findAll(prefix: String, node: Node, checkItself: Boolean = false): List<Pair<String, Int>> {
        val list = ArrayList<Pair<String, Int>>()
        if (checkItself) {
            if (node.times > 0) list += prefix to node.times
        }
        node.forEach { char, nextNode ->
            if (nextNode.times > 0) {
                list += (prefix + char) to nextNode.times
            }
            list += findAll(prefix + char, nextNode)
        }
        return list
    }

    fun input(c: Char): List<String> {
        if (c == '#') {
            insert(inputBuffer.joinToString(""))
            inputBuffer.clear()
            lastNode = root
            return emptyList()
        } else {
            lastNode = lastNode?.get(c)
            inputBuffer.add(c)
            if (lastNode == null) {
                return emptyList()
            } else {
                return findTop3(inputBuffer.joinToString(""), lastNode!!)
            }
        }
    }
}