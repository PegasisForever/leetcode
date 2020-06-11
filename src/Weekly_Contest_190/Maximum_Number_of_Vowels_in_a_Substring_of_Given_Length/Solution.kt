package Weekly_Contest_190.Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length

//https://leetcode.com/contest/weekly-contest-190/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
class Solution {
    fun Char.isVowel() = this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u'

    fun maxVowels(s: String, k: Int): Int {
        var count = 0
        var maxCount = 0
        repeat(k) { i ->
            if (s[i].isVowel()) count++
        }
        maxCount = count

        for (i in k..s.lastIndex) {
            if (s[i].isVowel()) count++
            if (s[i - k].isVowel()) count--
            maxCount = maxOf(maxCount, count)
        }

        return maxCount
    }
}
