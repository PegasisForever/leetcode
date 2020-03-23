package Queue_and_Stack.Decode_String

import java.util.*

fun main() {
    val data = arrayOf(
        "3[a]2[bc]",
        "3[a2[c]]",
        "2[abc]3[cd]ef",
        "leetcode",
        "leetcode3[ab]",
        "3[ab]leetcode"
    )
    val solution = Solution()
    for (d in data) {
        println(solution.decodeString(d))
    }
}

//https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
class Solution {
    data class State(
        var k: Int? = null,
        val kSb: StringBuilder = StringBuilder(),
        val sb: StringBuilder = StringBuilder()
    )

    fun State.append(other: State) {
        repeat(other.k!!) {
            sb.append(other.sb)
        }
    }

    fun decodeString(s: String): String {
        val stack = Stack<State>()
        stack.push(State(1))

        var currentState = State()
        "1[$s]".toCharArray().forEach { char ->
            when {
                char.isDigit() -> {
                    if (currentState.k != null) currentState = State()
                    currentState.kSb.append(char)
                }
                char == '[' -> {
                    currentState.k = currentState.kSb.toString().toInt()
                    stack.push(currentState)
                }
                char == ']' -> {
                    val state = stack.pop()
                    val previousState = stack.peek()
                    previousState.append(state)
                    currentState = previousState
                }
                else -> currentState.sb.append(char)
            }
        }

        return stack.pop().sb.toString()
    }

    fun Char.isDigit() = this.toInt() in 48..57
}