package Hash_Table.Find_Duplicate_Subtrees

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1127/
class Solution {
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode> {
        root ?: return emptyList()
        find(root)
        return resultMap.values.toList()
    }

    val resultMap = hashMapOf<String, TreeNode>()
    val hashMap = hashMapOf<String, TreeNode>()

    fun find(root: TreeNode?): StringBuilder {
        root ?: return StringBuilder("n")
        val sb = StringBuilder()
            .append("{")
            .append(find(root.left))
            .append("|")
            .append(root.`val`)
            .append("|")
            .append(find(root.right))
            .append("}")
        val str = sb.toString()
        if (str in hashMap.keys) {
            resultMap[str] = root
        } else {
            hashMap[str] = root
        }
        return sb
    }
}