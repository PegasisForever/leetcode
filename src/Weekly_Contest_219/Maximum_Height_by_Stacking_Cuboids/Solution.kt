package Weekly_Contest_219.Maximum_Height_by_Stacking_Cuboids

import println

fun main() {
    Solution().maxHeight(
        arrayOf(
            intArrayOf(50, 45, 20),
            intArrayOf(95, 37, 53),
            intArrayOf(45, 23, 12),
        )
    ).println()
}

// https://leetcode.com/contest/weekly-contest-219/problems/maximum-height-by-stacking-cuboids/
class Solution {
    data class Cube(val height: Int, val width: Int, val length: Int) {
        val volume = width * length * height

        fun canStackOn(other: Cube): Boolean {
            return this.width <= other.width &&
                    this.length <= other.length &&
                    this.height <= other.height
        }
    }

    fun getCubes(arg: IntArray): List<Cube> {
        arg.sort()
        return listOf(
            Cube(arg[0], arg[1], arg[2]),
            Cube(arg[0], arg[2], arg[1]),
            Cube(arg[1], arg[2], arg[0]),
            Cube(arg[1], arg[0], arg[2]),
            Cube(arg[2], arg[0], arg[1]),
            Cube(arg[2], arg[1], arg[0])
        )
    }

    fun maxHeight(cuboids: Array<IntArray>): Int {
        cubes = cuboids.map { getCubes(it) }.sortedByDescending { it[0].volume }
        return step(0, null)
    }

    lateinit var cubes: List<List<Cube>>
    val cache = hashMapOf<Pair<Int, Cube>, Int>()

    fun step(i: Int, lastCube: Cube?): Int {
        if (i == cubes.size) return 0
        if (lastCube != null) {
            val cached = cache[i to lastCube]
            if (cached != null) return cached
        }

        var result = step(i + 1, lastCube)
        for (cube in cubes[i]) {
            if (lastCube == null || cube.canStackOn(lastCube)) {
                result = maxOf(result, step(i + 1, cube) + cube.height)
            }
        }

        if (lastCube != null) {
            cache[i to lastCube] = result
        }
        return result
    }
}
