package Weekly_Contest_172.a

//https://leetcode.com/contest/weekly-contest-172/problems/maximum-69-number/
class Solution {
    fun maximum69Number (num: Int): Int {
        val s=num.toString()
        val i=s.indexOf("6")
        if (i!=-1) {
            s.toCharArray().apply {
                this[i]='9'
                return joinToString("").toInt()
            }
        }else{
            return num
        }
    }
}