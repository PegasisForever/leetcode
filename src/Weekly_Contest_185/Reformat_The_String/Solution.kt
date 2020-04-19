package Weekly_Contest_185.Reformat_The_String

import kotlin.math.abs

//https://leetcode.com/contest/weekly-contest-185/problems/reformat-the-string/
class Solution {
    fun reformat(s: String): String {
        val nums = s.filter { it.isDigit() }
        val chars = s.filter { !it.isDigit() }
        if (abs(nums.length - chars.length) <= 1) {
            val sb = StringBuilder()

            if (nums.length > chars.length) {
                sb.append(nums[0])
                repeat(chars.length) { i ->
                    sb.append(chars[i]).append(nums[i + 1])
                }
            } else if (nums.length == chars.length) {
                repeat(chars.length) { i ->
                    sb.append(chars[i]).append(nums[i])
                }
            } else {
                sb.append(chars[0])
                repeat(nums.length) { i ->
                    sb.append(nums[i]).append(chars[i + 1])
                }
            }
            return sb.toString()
        } else {
            return ""
        }
    }
}