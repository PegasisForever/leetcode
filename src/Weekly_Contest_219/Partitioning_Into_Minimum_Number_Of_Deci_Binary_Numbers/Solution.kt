package Weekly_Contest_219.Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers

class Solution {
    fun minPartitions(n: String): Int {
        var result = 0
        for (c in n) {
            result = maxOf(result, c.toInt() - 48)
        }

        return result
    }
}
