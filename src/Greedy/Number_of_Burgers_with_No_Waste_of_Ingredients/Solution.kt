package Greedy.Number_of_Burgers_with_No_Waste_of_Ingredients

// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
class Solution {
    fun numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List<Int> {
        if (tomatoSlices % 2 != 0) return emptyList()
        val jumbo = tomatoSlices / 2 - cheeseSlices
        val small = cheeseSlices - jumbo
        if (jumbo < 0 || small < 0) return emptyList()
        return listOf(jumbo, small)
    }
}
