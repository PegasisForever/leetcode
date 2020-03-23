package Queue_and_Stack.Evaluate_Reverse_Polish_Notation

import java.util.*

fun main() {
    val data = arrayOf(
        arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")
    )
    val solution = Solution()
    for (d in data) {
        println(solution.evalRPN(d))
    }
}

//https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        tokens.forEach { token ->
            if (token.isOperator()) {
                val num2 = stack.pop()
                val num1 = stack.pop()
                val result = calculate(num1, num2, token)
                stack.push(result)
            } else {
                stack.push(token.toInt())
            }
        }
        return stack.peek()
    }

    fun String.isOperator() = this == "+" || this == "-" || this == "*" || this == "/"

    fun calculate(num1: Int, num2: Int, operator: String) = when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> num1 / num2
        else -> error("wtf")
    }
}