package N_ary_Tree.Serialize_and_Deserialize_N_ary_Tree

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

//https://leetcode.com/explore/learn/card/n-ary-tree/132/conclusion/924/
class Codec {
    fun serialize(root: Node?): String {
        root ?: return ""
        return sStep(root).toString()
    }

    fun sStep(node: Node): StringBuilder {
        val sb = StringBuilder("{")
            .append(node.`val`)
            .append(":")
        node.children.forEach { child ->
            sb.append(sStep(child!!))
                .append("|")
        }
        sb.append("}")
        return sb
    }

    fun deserialize(data: String): Node? {
        if (data == "") return null
        return dStep(data)
    }

    fun dStep(str: String): Node {
        val nodeValueIndexEnd = str.indexOf(':')
        val node = Node(str.substring(1 until nodeValueIndexEnd).toInt())
        node.children = arrayListOf()

        var cursorLeft = nodeValueIndexEnd + 1
        var cursor = cursorLeft
        var extraLeftBracketCount = 0
        loop@ while (true) {
            val c = str[cursor]
            when {
                c == '{' -> extraLeftBracketCount++
                c == '}' -> if (extraLeftBracketCount == 0) {
                    break@loop
                } else {
                    extraLeftBracketCount--
                }
                c == '|' && extraLeftBracketCount == 0 -> {
                    (node.children as ArrayList).add(dStep(str.substring(cursorLeft until cursor)))
                    cursorLeft = cursor + 1
                }
            }
            cursor++
        }

        return node
    }
}
