package Hash_Table.Valid_Sudoku

//https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        repeat(9) y@{ y ->
            val set = hashSetOf<Char>()
            repeat(9) x@{ x ->
                val char = board[y][x]
                if (char == '.') return@x
                if (char in set) return false
                set += char
            }
        }

        repeat(9) x@{ x ->
            val set = hashSetOf<Char>()
            repeat(9) y@{ y ->
                val char = board[y][x]
                if (char == '.') return@y
                if (char in set) return false
                set += char
            }
        }

        repeat(3) { x ->
            repeat(3) { y ->
                if (!checkBlock(board,x*3,y*3)){
                    return false
                }
            }
        }

        return true
    }

    fun checkBlock(board: Array<CharArray>, baseX: Int, baseY: Int): Boolean {
        val set = hashSetOf<Char>()
        repeat(3) y@{ y ->
            repeat(3) x@{ x ->
                val char = board[y + baseY][x + baseX]
                if (char == '.') return@x
                if (char in set) return false
                set += char
            }
        }
        return true
    }
}