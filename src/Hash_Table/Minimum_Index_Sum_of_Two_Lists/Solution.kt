package Hash_Table.Minimum_Index_Sum_of_Two_Lists

//https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1177/
class Solution {
    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        val map1 = hashMapOf<String, Int>()
        list1.forEachIndexed { index, name -> map1[name] = index }
        val map2 = hashMapOf<String, Int>()
        list2.forEachIndexed { index, name -> map2[name] = index }

        val intersection = map1.keys.intersect(map2.keys)
        val list = arrayListOf<String>()
        var min = Int.MAX_VALUE
        intersection.forEach { name ->
            val sum = map1[name]!! + map2[name]!!
            if (sum < min) {
                min = sum
                list.clear()
                list += name
            } else if (sum == min) {
                list += name
            }
        }

        return list.toTypedArray()
    }
}