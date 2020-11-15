package Weekly_Contest_215.Design_an_Ordered_Stream

// https://leetcode.com/contest/weekly-contest-215/problems/design-an-ordered-stream/
class OrderedStream(val n: Int) {
    val arr = Array<String?>(n) { null }
    var ptr = 0
    fun insert(id: Int, value: String): List<String> {
        arr[id - 1] = value

        val list = arrayListOf<String>()
        while (ptr < n && arr[ptr] != null) {
            list.add(arr[ptr]!!)
            ptr++
        }
        return list
    }
}
