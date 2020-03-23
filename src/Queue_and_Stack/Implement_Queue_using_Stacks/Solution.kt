package Queue_and_Stack.Implement_Queue_using_Stacks

import java.util.*

//https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1386/
class MyQueue() {
    val stack = Stack<Int>()
    val stackReversed = Stack<Int>()

    private fun pour(fillStack: Boolean) {
        if (empty()) return
        if (fillStack && stack.isNotEmpty()) return
        if (!fillStack && stackReversed.isNotEmpty()) return

        if (stack.isEmpty()) {
            while (stackReversed.isNotEmpty()) {
                stack.push(stackReversed.pop())
            }
            stackReversed.empty()
        } else {
            while (stack.isNotEmpty()) {
                stackReversed.push(stack.pop())
            }
            stack.empty()
        }
    }

    fun push(x: Int) {
        pour(true)
        stack.push(x)
    }

    fun pop(): Int {
        pour(false)
        return stackReversed.pop()
    }

    fun peek(): Int {
        pour(false)
        return stackReversed.peek()
    }

    fun empty() = stack.isEmpty() && stackReversed.isEmpty()
}