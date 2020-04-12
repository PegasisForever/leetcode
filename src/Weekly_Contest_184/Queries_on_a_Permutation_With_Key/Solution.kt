package Weekly_Contest_184.b

//https://leetcode.com/contest/weekly-contest-184/problems/queries-on-a-permutation-with-key/
class Solution {
    fun processQueries(queries: IntArray, m: Int): IntArray {
        val p = IntArray(m){ it+1 }

        val result = IntArray(queries.size)

        queries.forEachIndexed { queryI, query ->
            val iInP = p.indexOf(query)
            result[queryI] = iInP

            for (i in iInP downTo 1) {
                p[i] = p[i - 1]
            }
            p[0] = query
        }

        return result
    }
}