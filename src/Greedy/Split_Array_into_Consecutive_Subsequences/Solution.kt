package Greedy.Split_Array_into_Consecutive_Subsequences

import java.util.*

// TODO
// https://leetcode.com/problems/split-array-into-consecutive-subsequences/
class Solution {
    fun isPossible(nums: IntArray): Boolean {
        val freq = HashMap<Int, Int>()
        val appendFreq = HashMap<Int, Int>()
        for (i in nums) freq[i] = (freq[i] ?: 0) + 1
        for (i in nums) {
            if (freq[i] == 0) {
                continue
            } else if (appendFreq[i] ?: 0 > 0) {
                appendFreq[i] = appendFreq[i]!! - 1
                appendFreq[i + 1] = (appendFreq[i + 1] ?: 0) + 1
            } else if (freq[i + 1] ?: 0 > 0 && freq[i + 2] ?: 0 > 0) {
                freq[i + 1] = freq[i + 1]!! - 1
                freq[i + 2] = freq[i + 2]!! - 1
                appendFreq[i + 3] = (appendFreq[i + 3] ?: 0) + 1
            } else {
                return false
            }
            freq[i] = freq[i]!! - 1
        }
        return true
    }
}
