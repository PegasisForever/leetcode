package b

fun main() {
    println(Solution().minDeletions("bbcebab"))
}

// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
class Solution {
    fun minDeletions(s: String): Int {
        val map = IntArray(26) { 0 }
        s.forEach { char ->
            map[char.toInt() - 97]++
        }

        val list = map.asList().sortedDescending().toMutableList()
        var count = 0
        for (i in 1..list.lastIndex) {
            if (list[i] == 0) break
            if (list[i] >= list[i - 1]) {
                if(list[i - 1]==0){
                    count += list[i]
                    list[i] =0
                }else{
                    count += list[i] - list[i - 1] + 1
                    list[i] = list[i - 1] - 1
                }
            }
        }

        return count
    }
}
