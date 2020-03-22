import kotlin.math.pow

inline fun count(digit: Int, base: Int, action: (IntArray) -> Unit) {
    val nums = IntArray(digit) { 0 }
    repeat(base.toDouble().pow(digit).toInt() - 1) {
        action(nums)
        nums[0]++

        var cursor = 0
        while (nums[cursor] >= base) {
            nums[cursor] = 0
            nums[cursor + 1]++
            cursor++
        }
    }
    action(nums)
}

inline fun count(base: Int, action: (ArrayList<Int>) -> Unit) {
    if (base == 1) {
        val nums = arrayListOf(0)
        while (true) {
            action(nums)
            nums.add(0)
        }
    } else {
        val nums = arrayListOf(0)
        while (true) {
            action(nums)
            nums[0]++

            var cursor = 0
            while (nums[cursor] >= base) {
                nums[cursor] = 0
                if (cursor + 1 == nums.size) nums.add(0)
                nums[cursor + 1]++
                cursor++
            }
        }
    }
}

inline fun countUnique(digit: Int, base: Int, action: (IntArray) -> Unit) {

}

fun primeList(max: Int): ArrayList<Int> {
    val notPrime = hashSetOf<Int>()
    for (num in 2..max) {
        if (num in notPrime) continue
        for (i in (num * 2)..max step num) {
            notPrime.add(i)
        }
    }

    val prime = arrayListOf<Int>()
    for (num in 2..max) {
        if (num !in notPrime) prime.add(num)
    }
    return prime
}