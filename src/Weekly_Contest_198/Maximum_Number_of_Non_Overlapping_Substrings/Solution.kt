package Weekly_Contest_198.Maximum_Number_of_Non_Overlapping_Substrings

// https://leetcode.com/contest/weekly-contest-198/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
class Solution {
    class SubData(
        val start: Int,
        val end: Int
    ) {
        fun length(): Int {
            return end - start
        }
    }

    fun maxNumOfSubstrings(s: String): List<String> {
        val firstIndexes = IntArray(26) { -1 }
        val lastIndexes = IntArray(26) { -1 }
        s.forEachIndexed { index, char ->
            val charI = char.toInt() - 97
            if (firstIndexes[charI] == -1) firstIndexes[charI] = index
            lastIndexes[charI] = index
        }

        repeat(26) { i ->
            if (firstIndexes[i] != -1) {
                subDatas.add(SubData(firstIndexes[i], lastIndexes[i]))
            }
        }
        subDatas.sortBy { it.length() }


        TODO()
    }

    val subDatas = ArrayList<SubData>(26)
    val result = ArrayList<String>()

    class MPair(var count: Int, var length: Int)

    // count, total length
    fun step(flags: BooleanArray = BooleanArray(subDatas.size)): Int {
        var maxCount=-1
        var bestFlag=flags
        subDatas.forEachIndexed { i, subData ->
            if (flags[i]) return@forEachIndexed
            val newFlag=flags.copyOf().apply { flags[i] = true }
            val newCount=step(newFlag)
        }
        TODO()
//        return subDatas.mapIndexed { i, subData ->
//            if (flags[i]) MPair(-1,-1)
//            val p = step(flags.copyOf().apply { flags[i] = true })
//            p.count++
//            p.length+=subData.length()
//            return@mapIndexed p
//        }.maxBy { it.count }!!
    }
}
