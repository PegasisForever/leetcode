package Greedy.Walking_Robot_Simulation

class Solution {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val obsSet = hashSetOf<Pair<Int, Int>>()
        obstacles.forEach { (x, y) ->
            obsSet += (x to y)
        }

        val north = 0 to 1
        val south = 0 to -1
        val east = 1 to 0
        val west = -1 to 0
        var x = 0
        var y = 0
        var (dx, dy) = north
        var ans = 0
        commands.forEach { cmd ->
            when (cmd) {
                -2 -> when (dx to dy) {
                    north -> west
                    west -> south
                    south -> east
                    east -> north
                    else -> error("")
                }.let {
                    dx = it.first
                    dy = it.second
                }
                -1 -> when (dx to dy) {
                    north -> east
                    east -> south
                    south -> west
                    west -> north
                    else -> error("")
                }.let {
                    dx = it.first
                    dy = it.second
                }
                else -> {
                    for (i in 0 until cmd) {
                        x += dx
                        y += dy
                        if ((x to y) in obsSet) {
                            x -= dx
                            y -= dy
                            break
                        }
                    }
                    ans = maxOf(ans, x * x + y * y)
                }
            }
        }

        return ans
    }
}
