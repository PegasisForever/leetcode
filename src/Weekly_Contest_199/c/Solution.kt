package Weekly_Contest_199.c

fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply {
            right = TreeNode(4)
        }
        right = TreeNode(3)
    }
    Solution().countPairs(root, 3)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    inner class Node(treeNode: TreeNode, distance: Int) {
        val value = treeNode.`val`
        val left: Node? = treeNode.left?.let { Node(it, distance) }
        val right: Node? = treeNode.right?.let { Node(it, distance) }
        val map = IntArray(101) { -1 } // value -> depth

        init {
            if (left == null && right == null) {
                map[value] = 0
            } else {
                val leftAvailableValues = arrayListOf<Int>()
                left?.map?.forEachIndexed { value, depth ->
                    if (value == 0) return@forEachIndexed
                    if (depth != -1) {
                        leftAvailableValues.add(value)
                        map[value] = depth
                    }
                }

                val rightAvailableValues = arrayListOf<Int>()
                right?.map?.forEachIndexed { value, depth ->
                    if (value == 0) return@forEachIndexed
                    if (depth != -1) {
                        rightAvailableValues.add(value)
                        if (map[value] == -1 || depth < map[value]) {
                            map[value] = depth
                        }
                    }
                }

                if (leftAvailableValues.isNotEmpty() && rightAvailableValues.isNotEmpty()) {
                    leftAvailableValues.forEach { leftValue ->
                        rightAvailableValues.forEach { rightValue ->
                            if (left!!.map[leftValue] + right!!.map[rightValue] + 2 <= distance) {
                                addPair(leftValue, rightValue)
                            }
                        }
                    }
                }

                repeat(101) {
                    val value = map[it]
                    if (value >= distance) {
                        map[it] = -1
                    } else if (value != -1) {
                        map[it]++
                    }
                }

            }
        }
    }

    fun addPair(a: Int, b: Int) {
        if (a > b) {
            set.add(a * 100 + b)
        } else {
            set.add(b * 100 + a)
        }
    }

    var set = hashSetOf<Int>()

    fun countPairs(root: TreeNode?, distance: Int): Int {
        root ?: return 0
        val root = Node(root, distance)

        return set.size
    }
}
