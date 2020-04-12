package interview.a

class Solution {
    fun checkRecord(s: String): Boolean {
        var aCount = 0
        var lCount = 0
        s.forEach { char ->
            when (char) {
                'A' -> {
                    aCount++
                    lCount = 0
                    if (aCount > 1) return false
                }
                'L' -> {
                    lCount++
                    if (lCount > 2) return false
                }
                else -> lCount = 0
            }
        }
        return true
    }
}