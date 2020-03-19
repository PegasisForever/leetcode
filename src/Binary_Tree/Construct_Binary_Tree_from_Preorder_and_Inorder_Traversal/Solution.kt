package Binary_Tree.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (inorder.isEmpty()) return null
        val root =
            TreeNode(preorder.first())

        val dividerIndex = inorder.indexOf(root.`val`)
        root.left = buildTree(
            preorder.copyOfRange(1, dividerIndex + 1),
            inorder.copyOfRange(0, dividerIndex)
        )
        root.right = buildTree(
            preorder.copyOfRange(dividerIndex + 1, preorder.size),
            inorder.copyOfRange(dividerIndex + 1, inorder.size)
        )

        return root
    }
}