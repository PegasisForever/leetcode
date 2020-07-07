package Arrays_101.Check_If_N_and_Its_Double_Exist

// https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val map = hashMapOf<Int, Int>()
        arr.forEachIndexed { i, num ->
            map[num] = i
        }

        arr.forEachIndexed { i,num ->
            val j = map[num*2] ?: return@forEachIndexed
            if (i==j) return@forEachIndexed
            return true
        }

        return false
    }
}
