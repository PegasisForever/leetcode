package Weekly_Contest_189.Rearrange_Words_in_a_Sentence

//https://leetcode.com/contest/weekly-contest-189/problems/rearrange-words-in-a-sentence/
class Solution {
    fun arrangeWords(text: String): String {
        val words = text.split(" ").mapIndexed { index, word -> index to word }.toMutableList()
        words[0] = 0 to words[0].second.toLowerCase()
        words.sortBy { (index, word) ->
            (word.length shl 16) + index
        }
        words[0] = 0 to (words[0].second[0].toUpperCase() + words[0].second.substring(1))
        return words.joinToString(" ") { it.second }
    }
}
