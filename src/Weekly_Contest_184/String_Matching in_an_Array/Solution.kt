package Weekly_Contest_184.a

//https://leetcode.com/contest/weekly-contest-184/problems/string-matching-in-an-array/
class Solution {
    fun stringMatching(words: Array<String>): List<String> {
        val result= arrayListOf<String>()
        words.forEachIndexed { index, word ->
            for (i in 0..words.lastIndex){
                if (i!=index && word in words[i]){
                    result+=word
                    break
                }
            }
        }

        return result
    }
}