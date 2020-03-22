package Weekly_Contest_181.Four_Divisors

fun divisors(n: Int): ArrayList<Int> {
    val list = arrayListOf<Int>()
    for (i in 1..n) if (n % i == 0) {
        list.add(i)
    }
    return list
}

//https://leetcode.com/contest/weekly-contest-181/problems/four-divisors/
class Solution {
    fun sumFourDivisors(nums: IntArray): Int {
        var sum = 0
        nums.forEach { num ->
            with(divisorSum(num)) {
                if (this > 0) {
                    sum += this
                }
            }
        }
        return sum
    }

    fun divisorSum(num: Int): Int {
        if (num < 2) return 0
        if (num in memo) return memo[num]!!
        var maxIndex = primeList.binarySearch(Math.sqrt(num.toDouble()).toInt() + 1)
        if (maxIndex < 0) maxIndex = -maxIndex - 2
        for (i in 0..maxIndex) {
            val currentPrime = primeList[i]
            if (num % currentPrime == 0) {
                val otherPrime = num / currentPrime
                if ((isPrime(otherPrime) || (otherPrime.sqrt()==currentPrime && isPrime(otherPrime.sqrt()))) && currentPrime != otherPrime) {
                    val result = 1 + currentPrime + otherPrime + num
                    memo[num] = result
                    return result
                } else {
                    memo[num] = 0
                    return 0
                }
            }
        }
        memo[num] = 0
        return 0
    }

    val memo = hashMapOf<Int, Int>()

    val primeList = calPrimeList()

    fun isPrime(n: Int) = primeList.binarySearch(n) >= 0

    fun Int.sqrt(): Int {
        val rooted = Math.sqrt(this.toDouble()).toInt()
        if (rooted * rooted == this) {
            return rooted
        } else {
            return 0
        }
    }

    fun calPrimeList(): ArrayList<Int> {
        val max = 100000
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
}