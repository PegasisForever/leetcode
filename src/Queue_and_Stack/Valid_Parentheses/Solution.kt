package Queue_and_Stack.Valid_Parentheses

import java.util.*
import kotlin.test.expect

fun main() {
    with(Solution()) {
        expect(true) { isValid("") }
        expect(true) { isValid("()[]{}") }
        expect(false) { isValid("(]") }
        expect(false) { isValid("([)]") }
        expect(true) { isValid("{[]}") }
    }
}

//https://leetcode.com/submissions/detail/314816883/
class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Int>()
        s.forEach { char ->
            try {
                when (char) {
                    '(' -> stack.push(0)
                    ')' -> if (stack.pop() != 0) return false
                    '[' -> stack.push(1)
                    ']' -> if (stack.pop() != 1) return false
                    '{' -> stack.push(2)
                    '}' -> if (stack.pop() != 2) return false
                }
            } catch (e: EmptyStackException) {
                return false
            }
        }
        return stack.isEmpty()
    }
}