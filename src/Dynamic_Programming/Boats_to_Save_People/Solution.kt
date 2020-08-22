package Dynamic_Programming.Boats_to_Save_People

// https://leetcode.com/problems/boats-to-save-people/
class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var p1 = 0
        var p2 = people.lastIndex
        var count = 0
        while (true) {
            if (p1 == p2) {
                count++
                break
            } else if (p1 > p2) {
                break
            } else if (people[p1] + people[p2] <= limit) {
                count++
                p1++
                p2--
            } else {
                count++
                p2--
            }
        }

        return count
    }
}
