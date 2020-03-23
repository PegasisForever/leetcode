package Queue_and_Stack.Clone_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
class Solution {
    HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (visited.containsKey(node)) return visited.get(node);

        Node clonedNode = new Node(node.val, new ArrayList<>());
        visited.put(node, clonedNode);
        for (Node neighbors : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbors));
        }
        return clonedNode;
    }
}


class Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        DFS(node);
        for (int i = 1; i < givenGraph.size() + 1; i++) {
            clonedGraph.add(new Node(i, new ArrayList<>()));
        }
        for (Node givenNode : givenGraph) {
            Node clonedNode = clonedGraph.get(givenNode.val - 1);
            for (Node givenConnectedNode : givenNode.neighbors) {
                clonedNode.neighbors.add(clonedGraph.get(givenConnectedNode.val - 1));
            }
        }
        return clonedGraph.get(node.val - 1);
    }

    void DFS(Node givenNode) {
        givenGraph.add(givenNode);
        for (Node nextNode : givenNode.neighbors) {
            if (!givenGraph.contains(nextNode)) {
                DFS(nextNode);
            }
        }
    }

    HashSet<Node> givenGraph = new HashSet<>();
    ArrayList<Node> clonedGraph = new ArrayList<>();
}