package Binary_Tree.Serialize_and_Deserialize_Binary_Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Codec {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        Codec codec = new Codec();
        codec.deserialize(codec.serialize(root));
    }

    public String serialize(TreeNode root) {
        return serializeSb(root).toString();
    }

    public StringBuilder serializeSb(TreeNode root) {
        if (root == null) return new StringBuilder("n");
        return new StringBuilder()
                .append(root.val)
                .append(":{")
                .append(serializeSb(root.left))
                .append(",")
                .append(serializeSb(root.right))
                .append("}");
    }

    public TreeNode deserialize(String data) {
        if (data.equals("n")) return null;
        int nodeValueIndexEnd = data.indexOf(':');
        TreeNode node = new TreeNode(Integer.parseInt(data.substring(0, nodeValueIndexEnd)));

        int valueDividerIndex = nodeValueIndexEnd + 2;
        int extraLeftBracketCount = 0;
        for (; valueDividerIndex < data.length(); valueDividerIndex++) {
            char c = data.charAt(valueDividerIndex);
            if (c == '{') {
                extraLeftBracketCount++;
            } else if (c == '}') {
                extraLeftBracketCount--;
            } else if (extraLeftBracketCount == 0 && c==',') {
                break;
            }
        }

        node.left = deserialize(data.substring(nodeValueIndexEnd + 2, valueDividerIndex));
        node.right = deserialize(data.substring(valueDividerIndex + 1, data.length() - 1));
        return node;
    }
}
