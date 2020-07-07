package Arrays_101.Duplicate_Zeros

// https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
class Solution {
    fun duplicateZeros(arr: IntArray) {
        val newArr = IntArray(arr.size)
        var i = 0;
        var newI = 0
        while (newI < arr.size) {
            val item = arr[i]
            if (item == 0) {
                i++
                newI += 2
            } else {
                newArr[newI] = item
                i++
                newI++
            }
        }

        for (i in arr.indices) {
            arr[i] = newArr[i]
        }
    }
}
