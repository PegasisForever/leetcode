package Weekly_Contest_189.People_Whose_List_of_Favorite_Companies_Is_Not_a_Subset_of_Another_List

//https://leetcode.com/contest/weekly-contest-189/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
class Solution {
    fun peopleIndexes(favoriteCompanies: List<List<String>>): List<Int> {
        val result = arrayListOf<Int>()
        val sets = favoriteCompanies.map { it.toSet() }

        sets.forEachIndexed { index, set ->
            var unique = true
            for (index2 in sets.indices) {
                if (index == index2) continue
                if (sets[index2].containsAll(set)) {
                    unique = false
                    break
                }
            }
            if (unique) result.add(index)
        }

        return result
    }
}
