package Weekly_Contest_190.Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence

//https://leetcode.com/contest/weekly-contest-190/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        sentence.split(" ")
            .forEachIndexed { index, word ->
                if (word.indexOf(searchWord) == 0) return index + 1
            }
        return -1
    }
}
