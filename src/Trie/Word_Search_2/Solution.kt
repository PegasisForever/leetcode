package Trie.Word_Search_2

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val s = Solution()
    println(
        s.findWords(
            arrayOf(
                charArrayOf('a', 'b'),
                charArrayOf('a','a')
            ), arrayOf("aaba","a","aa","abc")
        )
    )
}

//https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1056/
class Solution {
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

    fun remove(word: String) {
        val track = ArrayList<Node>()
        track.add(root)
        word.forEach { char ->
            track.add(track.last()[char]!!)
        }

        track.last().word = null
        for (i in track.lastIndex downTo 1) {
            if (track[i].word == null && track[i].isEmpty()) {
                track[i - 1].remove(word[i - 1])
            } else {
                break
            }
        }
    }

    data class Pos(val x: Int, val y: Int)

    fun Pos.possibleNextSteps() = arrayOf(
        this.copy(x = x + 1),
        this.copy(x = x - 1),
        this.copy(y = y + 1),
        this.copy(y = y - 1)
    )

    operator fun Array<CharArray>.get(pos: Pos) = this[pos.y][pos.x]

    operator fun Array<CharArray>.contains(pos: Pos) = (pos.y in 0 until height) && (pos.x in 0 until width)

    var height = 0
    var width = 0
    lateinit var board: Array<CharArray>
    var result = arrayListOf<String>()

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        height = board.size
        if (height == 0) return emptyList()
        width = board[0].size
        if (width == 0) return emptyList()
        this.board = board

        words.forEach { insert(it) }

        board.forEachIndexed { y, row ->
            row.forEachIndexed { x, char ->
                findWordFrom(
                    startPos = Pos(x, y),
                    visited = hashSetOf(Pos(x, y)),
                    node = root[char]
                )
            }
        }

        return result
    }

    private fun findWordFrom(startPos: Pos, visited: HashSet<Pos>, node: Node?) {
        node ?: return
        if (node.word != null) {
            result.add(node.word!!)
            remove(node.word!!)
        }
        if (node.isEmpty()) return

        startPos.possibleNextSteps().forEach { nextPos ->
            if (nextPos in board &&
                nextPos !in visited &&
                board[nextPos] in node
            ) findWordFrom(
                startPos = nextPos,
                visited = (visited.clone() as HashSet<Pos>).apply { add(nextPos) },
                node = node[board[nextPos]]
            )
        }
        return
    }
}