package Queue_and_Stack.Min_Stack

import java.util.*
import kotlin.math.min

//https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
class MinStack {
    val stack = Stack<Int>()
    val minStack = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
        if (stack.size == 1) {
            minStack.push(x)
        } else {
            minStack.push(min(minStack.peek(), x))
        }
    }

    fun pop() {
        minStack.pop()
        stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}