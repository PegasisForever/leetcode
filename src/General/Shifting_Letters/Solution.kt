package General.Shifting_Letters

fun main() {
    println(
        Solution().shiftingLetters(
            "mkgfzkkuxownxvfvxasy",
            intArrayOf(
                505870226,
                437526072,
                266740649,
                224336793,
                532917782,
                311122363,
                567754492,
                595798950,
                81520022,
                684110326,
                137742843,
                275267355,
                856903962,
                148291585,
                919054234,
                467541837,
                622939912,
                116899933,
                983296461,
                536563513
            )
        )
    )
}

class Solution {
    fun shiftingLetters(S: String, shifts: IntArray) = with(S.toCharArray()) {
        var sum: Long = 0
        for (i in shifts.size - 1 downTo 0) {
            sum += shifts[i]
            this[i] = ((this[i].toInt() - 97 + sum % 26) % 26 + 97).toChar()
        }
        this.joinToString("")
    }
}