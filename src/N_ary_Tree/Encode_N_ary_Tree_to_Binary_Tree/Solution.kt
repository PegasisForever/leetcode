package N_ary_Tree.Encode_N_ary_Tree_to_Binary_Tree

fun main() {
    val result = Codec().encode(Node(1).apply {
        children = listOf(
            Node(3).apply {
                children = listOf(
                    Node(5),
                    Node(6)
                )
            },
            Node(2),
            Node(4)
        )
    })
    println(result)
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/n-ary-tree/131/recursion/920/
class Codec {
    fun encode(node: Node?): TreeNode? {
        node ?: return null

        val treeNode = TreeNode(node.`val`)
        var firstChildNode: TreeNode? = null
        var curr = firstChildNode
        node.children.forEach { child ->
            val newChildNode = encode(child)
            if (firstChildNode == null) {
                firstChildNode = newChildNode
                curr = newChildNode
            } else {
                curr!!.right = newChildNode
                curr = newChildNode
            }
        }
        treeNode.left = firstChildNode
        return treeNode
    }

    fun decode(treeNode: TreeNode?): Node? {
        treeNode ?: return null

        val node = Node(treeNode.`val`)
        node.children = arrayListOf()
        var currChild = treeNode.left
        while (currChild != null) {
            (node.children as ArrayList).add(decode(currChild))
            currChild = currChild.right
        }

        return node
    }
}