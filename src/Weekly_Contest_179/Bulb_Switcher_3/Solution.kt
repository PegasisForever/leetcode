package Weekly_Contest_179.Bulb_Switcher_3

//https://leetcode.com/contest/weekly-contest-179/problems/bulb-switcher-iii/
class Solution {
    enum class State {
        OFF, ON, BLUE
    }

    class Light(var state: State = State.OFF)

    fun update() {
        var state = 0
        var addCount = true
        for (i in 0 until lights.size) {
            val light = lights[i]
            if (state == 0) {
                if (light.state == State.ON) {
                    light.state == State.BLUE
                } else if (light.state == State.OFF) {
                    state = 1
                }
            } else {
                if (light.state == State.ON) {
                    addCount = false
                    break
                }
            }
        }
        if (addCount) count++
    }

    lateinit var lights: Array<Light>
    var count = 0

    fun numTimesAllBlue(instructions: IntArray): Int {
        lights = Array(instructions.size) { Light() }

        instructions.forEach { ins ->
            lights[ins - 1].state = State.ON
            update()
        }

        return count
    }
}