package Weekly_contest_209.Maximum_Number_of_Visible_Points

import println


fun main() {
    Solution().visiblePoints(
        listOf(
            listOf(198768142, 325231488),
            listOf(730653894, 526879029),
            listOf(482566443, 124650516),
            listOf(301750308, 786306795),
            listOf(428637509, 388444545),
            listOf(824139468, 560868920),
            listOf(46101719, 541790947),
            listOf(33117389, 306138652),
            listOf(379129552, 739264502),
            listOf(632078701, 382510936),
            listOf(648669937, 641406148),
            listOf(402494603, 290848535),
            listOf(681757446, 651339050),
            listOf(755146968, 328108553),
            listOf(856055968, 54585842),
            listOf(642810790, 781285498),
            listOf(624780623, 839525682),
            listOf(225552068, 597591380),
            listOf(941428680, 575243295),
            listOf(904246597, 409781914),
            listOf(133988308, 424694994),
            listOf(263860625, 642729245),
            listOf(725256971, 428462957),
            listOf(951188673, 24284291),
            listOf(65878467, 597579989),
            listOf(423910337, 760218568),
            listOf(375233659, 465709839),
            listOf(39079416, 44449206),
            listOf(76488044, 376497238),
            listOf(768046853, 401132958),
            listOf(862857872, 713625310),
            listOf(834212457, 613684155),
            listOf(145940546, 414657761),
            listOf(438671565, 895069996),
            listOf(486059332, 78047139),
            listOf(539611528, 236860222),
            listOf(328891159, 833572609),
            listOf(561041358, 896191043),
            listOf(469734995, 511499580),
            listOf(868786087, 593647615),
            listOf(502014973, 630219398),
            listOf(834825976, 939531210),
            listOf(232809706, 831430339),
            listOf(446916520, 518080962),
            listOf(516594877, 208057152),
            listOf(851130172, 768268153),
            listOf(665228968, 134767900),
            listOf(347594646, 46036486),
            listOf(675842115, 24895986),
            listOf(877430373, 353382710),
            listOf(167579980, 47992154),
            listOf(125351210, 769215749),
            listOf(438404131, 569154245),
            listOf(604952972, 128325995),
            listOf(304627075, 646626043),
            listOf(651998767, 527382342),
            listOf(121415369, 22955171),
            listOf(46278664, 726969424),
            listOf(650197837, 730272955),
            listOf(326340006, 424213045),
            listOf(242071539, 679004233),
            listOf(208227275, 449583956),
            listOf(688763276, 330569373),
            listOf(657221239, 659946024),
            listOf(760680906, 398786962),
            listOf(695186876, 163719246),
            listOf(416909447, 908414565),
            listOf(59247263, 674732497),
            listOf(396812330, 607544608),
            listOf(752069054, 728117920)
        ),
        86,
        listOf(136181398, 475556834)
    ).println()
}

// https://leetcode.com/contest/weekly-contest-209/problems/maximum-number-of-visible-points/
class Solution {
    fun visiblePoints(points: List<List<Int>>, angle: Int, location: List<Int>): Int {
        val angle = angle + 0.000001
        val x = location[0]
        val y = location[1]
        var alwaysVisible = 0
        val pointAngles = points.mapNotNull { (pointX, pointY) ->
            val dx = (pointX - x).toDouble()
            val dy = (pointY - y).toDouble()

            if (dx == 0.0 && dy == 0.0) {
                alwaysVisible++
                null
            } else {
                var degree = Math.atan2(dy, dx) * 57.29578
                if (degree < 0) degree += 360
                degree
            }
        }.sorted()

        val searchMax = pointAngles.size * 2 - 1
        var startPointI = 0
        var startPoint = pointAngles[startPointI]
        var endAngle = startPoint + angle
        var endPointI = binaryFindFirst(0, pointAngles.size) { i ->
            return@binaryFindFirst if (i >= pointAngles.size) {
                pointAngles[i - pointAngles.size] + 360 > endAngle
            } else {
                pointAngles[i] > endAngle
            }
        }!! - 1
        var maxCount = endPointI - startPointI + 1

        while (endAngle < 360 + angle && startPointI < pointAngles.size - 1) {
            if (maxCount == pointAngles.size) break
            startPointI++
            startPoint = pointAngles[startPointI]
            endAngle = startPoint + angle
            endPointI = binaryFindFirst(
                endPointI,
                (endPointI + pointAngles.size + 1).coerceAtMost(searchMax)
            ) { i ->
                return@binaryFindFirst if (i >= pointAngles.size) {
                    pointAngles[i - pointAngles.size] + 360 > endAngle
                } else {
                    pointAngles[i] > endAngle
                }
            }!! - 1
            maxCount = maxOf(maxCount, endPointI - startPointI + 1)
        }

        return maxCount + alwaysVisible
    }

    // from: include  to: include
    inline fun binaryFindFirst(from: Int, to: Int, action: (Int) -> Boolean): Int? {
        var left = from
        var right = to
        var mid: Int
        while (left < right) {
            mid = left + (right - left) / 2
            if (action(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return if (left == to) {
            if (action(to)) {
                to
            } else {
                null
            }
        } else {
            left
        }
    }
}
