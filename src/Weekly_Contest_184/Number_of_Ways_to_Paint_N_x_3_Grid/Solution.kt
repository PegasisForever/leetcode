package Weekly_Contest_184.d

enum class Type(val a: Int, val b: Int, val c: Int) {
    A(1, 2, 1),
    B(1, 2, 3),
    C(1, 3, 1),
    D(1, 3, 2),
    E(2, 1, 2),
    F(2, 1, 3),
    G(2, 3, 1),
    H(2, 3, 2),
    I(3, 1, 2),
    J(3, 1, 3),
    K(3, 2, 1),
    L(3, 2, 3);
}

private val map = HashMap<Type, List<Type>>()

fun Type.next(): List<Type> {
    if (this in map) {
        return map[this]!!
    }

    val result = enumValues<Type>().filter { it.a != a && it.b != b && it.c != c }
    map[this] = result
    return result
}

class Solution {
    val M = 1000000007

    fun numOfWays(n: Int): Int {
        var sum = 0L
        enumValues<Type>().forEach { nextState ->
            sum += step(nextState, n) % M
        }
        return (sum % M).toInt()
    }

    fun step(state: Type, iteration: Int): Int {
        if (iteration == 1) return 1
        val pair = state to iteration
        if (pair in memo) {
            return memo[pair]!!
        }


        var sum = 0L
        state.next().forEach { nextState ->
            sum += step(nextState, iteration - 1) % M
        }
        val sumInt = (sum % M).toInt()

        memo[pair] = sumInt
        return sumInt
    }

    companion object {
        val memo = hashMapOf<Pair<Type, Int>, Int>()
    }
}