package General.Remove_Vowels_from_a_String

//https://leetcode.com/problems/remove-vowels-from-a-string/
class Solution {
    fun removeVowels(S: String): String {
        return S.toCharArray()
            .filter { char -> char != 'a' && char != 'e' && char != 'i' && char != 'o' && char != 'u' }.joinToString("")
    }
}