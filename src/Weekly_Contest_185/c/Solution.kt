package Weekly_Contest_185.c

fun main() {
    Solution().minNumberOfFrogs("croakcroak")
}

//https://leetcode.com/contest/weekly-contest-185/problems/minimum-number-of-frogs-croaking/
class Solution {
    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        //                               c  r  o  a
        val frogs = arrayOf(0, 0, 0, 0, 0)
        val map = hashMapOf('r' to 1, 'o' to 2, 'a' to 3)

        croakOfFrogs.forEach { char ->
            if (char == 'c') {
                if (frogs[0] == 0) {
                    frogs[1]++
                } else {
                    frogs[0]--
                    frogs[1]++
                }
            } else if (char == 'r' || char == 'o' || char == 'a') {
                val start = map[char]!!
                if (frogs[start] == 0) {
                    return -1
                } else {
                    frogs[start]--
                    frogs[start + 1]++
                }
            } else if (char == 'k') {
                if (frogs[4] == 0) {
                    return -1
                } else {
                    frogs[4]--
                    frogs[0]++
                }
            } else {
                return -1
            }
        }

        if (frogs[1] != 0 || frogs[2] != 0 || frogs[3] != 0 || frogs[4] != 0) return -1
        return frogs[0]
    }
}