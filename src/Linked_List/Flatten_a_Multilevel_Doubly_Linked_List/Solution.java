package Linked_List.Flatten_a_Multilevel_Doubly_Linked_List;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

//https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/
class Solution {
    public Node flatten(Node head) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.child != null) {
                Node childHead = flatten(currNode.child);
                currNode.child = null;
                Node childEnd = getEndNode(childHead);
                Node nextNode = currNode.next;

                childHead.prev = currNode;
                currNode.next = childHead;

                if (nextNode != null) nextNode.prev = childEnd;
                childEnd.next = nextNode;

                currNode = nextNode;
            } else {
                currNode = currNode.next;
            }
        }

        return head;
    }

    public Node getEndNode(Node head) {
        Node currNode = head;
        while (true) {
            if (currNode.next == null) {
                return currNode;
            }
            currNode = currNode.next;
        }
    }
}