package Binary_Tree.Lowest_Common_Ancestor_of_a_Binary_Tree;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//Timeout
//https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        LinkedList<TreeNode> rootPath = new LinkedList<>();
        rootPath.add(root);
        findPD(root, rootPath);

        int maxLevel = Math.min(pPath.length, qPath.length) - 1;
        for (int level = 0; level <= maxLevel; level++) {
            if (pPath[level] != qPath[level]) return (TreeNode) pPath[level - 1];
        }
        return (TreeNode) pPath[maxLevel];
    }

    TreeNode p;
    TreeNode q;
    Object[] pPath = null;
    Object[] qPath = null;

    void findPD(TreeNode root, LinkedList<TreeNode> path) {
        if (pPath != null && qPath != null) return;

        if (root == p) {
            pPath = path.toArray();
        } else if (root == q) {
            qPath = path.toArray();
        }

        if (root.left != null) {
            LinkedList<TreeNode> leftPath = (LinkedList<TreeNode>) path.clone();
            leftPath.add(root.left);
            findPD(root.left, leftPath);
        }

        if (root.right != null) {
            LinkedList<TreeNode> rightPath = (LinkedList<TreeNode>) path.clone();
            rightPath.add(root.right);
            findPD(root.right, rightPath);
        }
    }
}
