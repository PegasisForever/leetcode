package Greedy.Group_the_People_Given_the_Group_Size_They_Belong_To

// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
class Solution {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        var persons = groupSizes.mapIndexed { index, size -> index to size }
        persons = persons.sortedBy { it.second }

        val result = arrayListOf<List<Int>>()
        var temp = arrayListOf<Int>()
        var lastSize: Int? = null
        persons.forEach { (id, size) ->
            if ((lastSize == null || size == lastSize) && temp.size < size) {
                temp.add(id)
            } else {
                result.add(temp)
                temp = arrayListOf()
                temp.add(id)
            }
            lastSize = size
        }
        if (temp.isNotEmpty()) result.add(temp)
        return result
    }
}