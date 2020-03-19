package Binary_Tree.Lowest_Common_Ancestor_of_a_Binary_Tree;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        findPQ(root, 0);
        return node;
    }

    TreeNode p;
    TreeNode q;
    int maxLevel = -1;
    TreeNode node = null;

    FindResult findPQ(TreeNode root, int level) {
        if (root == null) return new FindResult(false, false);

        FindResult result = FindResult.add(findPQ(root.left, level + 1), findPQ(root.right, level + 1));
        result.p = result.p || root == p;
        result.q = result.q || root == q;
        if (result.foundBoth() && level > maxLevel) {
            maxLevel = level;
            node = root;
        }

        return result;
    }
}

class FindResult {
    boolean p;
    boolean q;

    FindResult(boolean p, boolean q) {
        this.p = p;
        this.q = q;
    }

    boolean foundBoth() {
        return p && q;
    }

    static FindResult add(FindResult a, FindResult b) {
        return new FindResult(a.p || b.p, a.q || b.q);
    }
}