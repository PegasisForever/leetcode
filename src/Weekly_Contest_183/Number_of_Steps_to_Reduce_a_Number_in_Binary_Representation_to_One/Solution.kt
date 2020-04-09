package Weekly_Contest_183.Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One

//https://leetcode.com/contest/weekly-contest-183/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
class Solution {
    fun numSteps(s: String): Int {
        val charList = ArrayList(s.map { if (it == '0') 0 else 1 })
        var step=0
        while (charList.size != 1 && charList[0] == 1) {
            if (charList.last() == 0) {
                charList.removeAt(charList.lastIndex)
            } else {
                charList[charList.lastIndex]++
                var cursor = charList.lastIndex
                while (charList[cursor] > 1) {
                    charList[cursor] = 0
                    if (cursor == 0) {
                        charList.add(0, 1)
                        break
                    }
                    charList[cursor - 1]++
                    cursor--
                }
            }
            step++
        }
        return step
    }
}