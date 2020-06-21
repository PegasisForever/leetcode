package Arrays_101.Squares_of_a_Sorted_Array

//https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3240/
class Solution {
    fun sortedSquares(arr: IntArray): IntArray {
        return arr.map { it*it }.sorted().toIntArray()
    }
}
