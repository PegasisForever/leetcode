package Weekly_Contest_199.b

class Solution {
    fun minFlips(target: String): Int {
        var count = 0
        var last = '0'
        target.forEach { state ->
            if (state != last) {
                last = state
                count++
            }
        }
        return count
    }
}
