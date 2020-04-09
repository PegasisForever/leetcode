package Weekly_Contest_183.Longest_Happy_String

fun main() {
    Solution().longestDiverseString(1, 1, 7)
}

class Solution {
    data class In(var value: Int) {
        operator fun compareTo(other: Any) = when (other) {
            is Int -> value.compareTo(other)
            is In -> value.compareTo(other.value)
            else -> error("")
        }
    }

    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        var sb = StringBuilder()
        var a = In(a)
        var b = In(b)
        var c = In(c)

        var lastChar: Char? = null

        while (a.value + b.value + c.value > 0) {
            var useAll = false
            val (max, char) = if (lastChar == 'a') {
                if (b.value != 0 && b >= c) {
                    useAll = b > a
                    b to 'b'
                } else if (c.value != 0) {
                    useAll = c > a
                    c to 'c'
                } else {
                    break
                }
            } else if (lastChar == 'b') {
                if (a.value != 0 && a >= c) {
                    useAll = a > b
                    a to 'a'
                } else if (c.value != 0) {
                    useAll = c > b
                    c to 'c'
                } else {
                    break
                }
            } else if (lastChar == 'c') {
                if (a.value != 0 && a >= b) {
                    useAll = a > c
                    a to 'a'
                } else if (b.value != 0) {
                    useAll = b > c
                    b to 'b'
                } else {
                    break
                }
            } else {
                if (a.value != 0 && a >= b && a >= c) {
                    useAll = a > b && a > c
                    a to 'a'
                } else if (b.value != 0 && b >= a && b >= c) {
                    useAll = b > a && b > c
                    b to 'b'
                } else {
                    useAll = c > a && c > b
                    c to 'c'
                }
            }

            if (max.value >= 2 && useAll) {
                lastChar = char
                sb.append(char).append(char)
                max.value -= 2
            } else {
                lastChar = char
                sb.append(char)
                max.value--
            }
        }

        return sb.toString()
    }
}