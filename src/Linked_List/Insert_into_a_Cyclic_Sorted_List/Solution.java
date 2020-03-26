package Linked_List.Insert_into_a_Cyclic_Sorted_List;

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

//https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1226/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        } else if (head.next == head) {
            head.next = insertNode;
            insertNode.next = head;
            return head;
        }

        Node currNode = head;
        while (true) {
            Node nextNode = currNode.next;
            if (nextNode == head && currNode.val == nextNode.val) {
                currNode.next = insertNode;
                insertNode.next = nextNode;
                return head;
            }
            if (nextNode.val >= currNode.val) {
                if (insertVal >= currNode.val && insertVal <= nextNode.val) {
                    currNode.next = insertNode;
                    insertNode.next = nextNode;
                    return head;
                }
            } else {
                if (insertVal >= currNode.val || insertVal <= nextNode.val) {
                    currNode.next = insertNode;
                    insertNode.next = nextNode;
                    return head;
                }
            }
            currNode = nextNode;
        }
    }
}