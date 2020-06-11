package weekly_Contest_191.Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts

//https://leetcode.com/contest/weekly-contest-191/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
class Solution {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        val sortedHCuts = horizontalCuts.sorted()
        val sortedVCuts = verticalCuts.sorted()

        var maxH = 0
        for (i in sortedHCuts.indices) {
            val d = sortedHCuts[i]
            maxH = if (i == 0) {
                d
            } else {
                maxOf(maxH, d - sortedHCuts[i - 1])
            }
        }
        maxH = maxOf(maxH, h - sortedHCuts.last())

        var maxV = 0
        for (i in sortedVCuts.indices) {
            val d = sortedVCuts[i]
            maxV = if (i == 0) {
                d
            } else {
                maxOf(maxV, d - sortedVCuts[i - 1])
            }
        }
        maxV = maxOf(maxV, w - sortedVCuts.last())

        return (maxH.toLong() * maxV.toLong() % 1000000007).toInt()
    }
}
