import kotlin.math.pow
import kotlin.math.sqrt

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

class RollingHasher(initString: String) {
    var hash = 0
    private var bToN = 1

    init {
        val windowSize = initString.length
        repeat(windowSize) {
            bToN *= 31
        }
        initString.forEach { char ->
            hash = 31 * hash + char.hashCode()
        }
    }

    fun update(outChar: Char, inChar: Char): Int {
        hash = 31 * hash + inChar.hashCode() - bToN * outChar.hashCode()
        return hash
    }
}

fun reverse(array: CharArray, start: Int, end: Int) {
    var i = start
    var j = end
    repeat((j - i + 1) / 2) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
        i++
        j--
    }
}

val charHashMap = IntArray(26).apply {
    var sum = 1
    repeat(26) { i ->
        sum *= 31
        this[i] = sum
    }
}

fun Int.toBitArray(): BooleanArray {
    return BooleanArray(31) { i ->
        ((this shr (30 - i)) and 1) == 1
    }
}

fun BooleanArray.toInt(): Int {
    if (this.size != 31) error("Array length must equal 31.")
    var result = 0
    repeat(31) { i ->
        result += (if (this[i]) 1 else 0) shl (30 - i)
    }
    return result
}

infix fun BooleanArray.and(other: BooleanArray): BooleanArray {
    val resultLength = maxOf(this.size, other.size)
    val thisOffset = this.size - resultLength
    val otherOffset = other.size - resultLength
    return BooleanArray(resultLength) { i ->
        (this.getOrNull(i + thisOffset) ?: false) &&
                (other.getOrNull(i + otherOffset) ?: false)
    }
}

fun IntArray.circleGet(i: Int): Int {
    var index = if (i >= 0) {
        i % size
    } else {
        size + (i % size)
    }
    if (index == size) index = 0
    return get(index)
}

fun primeFactors(n: Int): List<Int> {
    val result = arrayListOf<Int>()
    var n = n
    while (n % 2 == 0) {
        result += 2
        n /= 2
    }

    var i = 3
    while (i <= sqrt(n.toDouble())) {
        while (n % i == 0) {
            result += i
            n /= i
        }
        i += 2
    }

    if (n > 2) result += n
    return result
}

fun String.toMap(): HashMap<Char, Int> {
    val map = hashMapOf<Char, Int>()
    forEach { char ->
        map[char] = (map[char] ?: 0) + 1
    }
    return map
}

fun IntArray.toCountMap(): Map<Int, Int> {
    val map = hashMapOf<Int, Int>()
    forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    return map
}

fun IntArray.toCountList(): List<Pair<Int, Int>> {
    val map = hashMapOf<Int, Int>()
    forEach {
        map[it] = (map[it] ?: 0) + 1
    }
    return map.toList().sortedBy { it.second }
}

fun Any?.println() = println(this)

// from: include  to: include
inline fun binaryFindFirst(from: Int, to: Int, action: (Int) -> Boolean): Int? {
    var left = from
    var right = to
    var mid: Int
    while (left < right) {
        mid = left + (right - left) / 2
        if (action(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return if (left == to) {
        if (action(to)) {
            to
        } else {
            null
        }
    } else {
        left
    }
}


// from: include  to: include  getCompareResult: return is given int too large?(+1)
inline fun binaryFindExact(from: Int, to: Int, getCompareResult: (Int) -> Int): Int? {
    var left = from
    var right = to

    while (true) {
        val mid = left + (right - left) / 2
        val com = getCompareResult(mid)

        when {
            com == 0 -> return mid
            com > 0 -> right = mid - 1
            else -> left = mid + 1
        }
        if (right < left) return null
    }
}
