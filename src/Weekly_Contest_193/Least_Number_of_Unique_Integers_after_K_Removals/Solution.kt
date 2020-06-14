package Weekly_Contest_193.Least_Number_of_Unique_Integers_after_K_Removals

//https://leetcode.com/contest/weekly-contest-193/problems/least-number-of-unique-integers-after-k-removals/
class Solution {
    fun IntArray.toCountList(): List<Pair<Int, Int>> {
        val map = hashMapOf<Int, Int>()
        forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        return map.toList().sortedBy { it.second }
    }

    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val list = arr.toCountList()
        var remainingK = k
        var remainingUnique = list.size
        list.forEach { (num, count) ->
            if (count <= remainingK) {
                remainingK -= count
                remainingUnique--
            } else {
                return remainingUnique
            }
        }
        return 0
    }
}
