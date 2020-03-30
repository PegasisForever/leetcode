package Weekly_Contest_182.Design_Underground_System

//https://leetcode.com/contest/weekly-contest-182/problems/design-underground-system/
class UndergroundSystem2 {
    val hashMap = hashMapOf<Pair<String, String>, TimeState>()
    val riders = hashMapOf<Int, RiderState>()

    data class TimeState(var timeSum: Int = 0, var f: Int = 0)
    data class RiderState(val enterStationName: String, val enterTime: Int)

    fun checkIn(id: Int, stationName: String, t: Int) {
        riders[id] = RiderState(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val rider = riders[id]!!
        val deltaT = t - rider.enterTime
        val key = rider.enterStationName to stationName
        hashMap[key] = (hashMap[key] ?: TimeState()).apply {
            timeSum += deltaT
            f++
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val state = hashMap[startStation to endStation]!!
        return state.timeSum.toDouble() / state.f
    }
}