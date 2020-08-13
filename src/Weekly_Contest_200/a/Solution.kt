package Weekly_Contest_200.a

import kotlin.math.abs

class Solution {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var count = 0
        for (i in 0..(arr.lastIndex - 2)) {
            for (j in (i + 1)..(arr.lastIndex - 1)) {
                for (k in (j + 1)..arr.lastIndex) {
                    if (abs(arr[i] - arr[j]) <= a && abs(arr[j] - arr[k]) <= b && abs(arr[i] - arr[k]) <= c) {
                        count++
                    }
                }
            }
        }
        return count
    }
}
