package Queue_and_Stack.Open_the_Lock

import java.util.*

fun main() {
    val deadends = arrayOf("0201", "0101", "0102", "1212", "2002")
    val target = "0202"

    Solution().openLock(deadends, target)
}

//https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1375/
class Solution {
    data class State(var a: Int, var b: Int, var c: Int, var d: Int) {
        init {
            if (a == 10) a = 0 else if (a == -1) a = 9
            if (b == 10) b = 0 else if (b == -1) b = 9
            if (c == 10) c = 0 else if (c == -1) c = 9
            if (d == 10) d = 0 else if (d == -1) d = 9
        }

        constructor(str: String) : this(
            str[0].toInt() - 48,
            str[1].toInt() - 48,
            str[2].toInt() - 48,
            str[3].toInt() - 48
        )

        fun possibleSteps() = arrayOf(
            copy(a = this.a + 1),
            copy(a = this.a - 1),
            copy(b = this.b + 1),
            copy(b = this.b - 1),
            copy(c = this.c + 1),
            copy(c = this.c - 1),
            copy(d = this.d + 1),
            copy(d = this.d - 1)
        )

        override fun toString() = "${a}${b}${c}${d}"
    }

    fun State.isDeadEnd() = deadends.find { it == this } != null
    fun State.isTarget() = target == this

    lateinit var deadends: List<State>
    lateinit var target: State

    fun openLock(deadends: Array<String>, target: String): Int {
        this.deadends = deadends.map { State(it) }
        this.target = State(target)

        val queue: Queue<State> = LinkedList()
        val visited = hashSetOf<State>()

        var distance = -1
        val startState = State(0, 0, 0, 0)
        if (startState.isTarget()) return 0
        queue.add(startState)
        visited.add(startState)

        while (queue.isNotEmpty()) {
            distance++
            repeat(queue.size) {
                val currentState = queue.remove()
                if (currentState.isDeadEnd()) return@repeat
                if (currentState.isTarget()) return distance

                for (nextState in currentState.possibleSteps()) {
                    if (!visited.contains(nextState)) {
                        queue.offer(nextState)
                        visited.add(nextState)
                    }
                }
            }
        }

        return -1
    }
}