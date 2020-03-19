package Binary_Tree.Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty()) return null
        val root =
            TreeNode(postorder.last())

        val dividerIndex = inorder.indexOf(root.`val`)
        root.left = buildTree(
            inorder.copyOfRange(0, dividerIndex),
            postorder.copyOfRange(0, dividerIndex)
        )
        root.right = buildTree(
            inorder.copyOfRange(dividerIndex + 1, inorder.size),
            postorder.copyOfRange(dividerIndex, postorder.size - 1)
        )

        return root
    }
}