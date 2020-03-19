package Binary_Tree.Populating_Next_Right_Pointers_in_Each_Node;

import java.util.ArrayList;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {
    public Node connect(Node root) {
        step(root, 0);
        return root;
    }


    ArrayList<Node> lastRightNode = new ArrayList<>();

    void step(Node root, int level) {
        if (root == null) return;

        if (lastRightNode.size() == level) lastRightNode.add(null);
        root.next = lastRightNode.get(level);
        lastRightNode.set(level, root);

        step(root.right, level + 1);
        step(root.left, level + 1);
    }
}
