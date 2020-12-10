package Weekly_Contest_218.Goal_Parser_Interpretation

// https://leetcode.com/contest/weekly-contest-218/problems/goal-parser-interpretation/
class Solution {
    fun interpret(command: String): String {
        return command.replace("(al)","al").replace("G","G").replace("()","o")
    }
}
