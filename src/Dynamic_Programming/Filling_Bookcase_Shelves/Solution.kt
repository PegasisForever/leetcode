package Dynamic_Programming.Filling_Bookcase_Shelves

import kotlin.properties.Delegates

// https://leetcode.com/problems/filling-bookcase-shelves/
class Solution {
    fun minHeightShelves(books: Array<IntArray>, shelf_width: Int): Int {
        this.books = books
        this.width = shelf_width
        cache = Array(books.size + 1) { IntArray(width + 1) { Int.MIN_VALUE } }

        return dp(0, 0, 0)
    }

    lateinit var books: Array<IntArray>
    var width by Delegates.notNull<Int>()
    lateinit var cache: Array<IntArray>

    fun dp(i: Int, currH: Int, currW: Int): Int {
        if (i == books.size) return currH
        if (cache[i][currW] != Int.MIN_VALUE) return cache[i][currW]

        val book = books[i]

        return if (currH == 0) {
            dp(i + 1, book[1], book[0])
        } else if (currW + book[0] <= width) {
            minOf(
                dp(i + 1, maxOf(currH, book[1]), currW + book[0]),
                currH + dp(i, 0, 0)
            )
        } else {
            currH + dp(i, 0, 0)
        }.also { cache[i][currW] = it }
    }
}
