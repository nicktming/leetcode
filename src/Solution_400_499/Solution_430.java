package Solution_400_499;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Solution_430 {
    public static void main(String[] args) {
        Solution_430 test = new Solution_430();
        Node[] nodes = new Node[13];
        for (int i = 1; i <= 12; i++) {
            nodes[i] = new Node();
            nodes[i].val = i;
        }
        nodes[1].next = nodes[2];
        nodes[2].prev = nodes[1];
        nodes[2].next = nodes[3];
        nodes[3].prev = nodes[2];
        nodes[3].child = nodes[7];
        nodes[3].next = nodes[4];
        nodes[4].prev = nodes[3];
        nodes[4].next = nodes[5];
        nodes[5].prev = nodes[4];
        nodes[5].next = nodes[6];
        nodes[6].prev = nodes[5];

        nodes[7].next = nodes[8];
        nodes[8].prev = nodes[7];
        nodes[8].next = nodes[9];
        nodes[9].prev = nodes[8];
        nodes[9].next = nodes[10];
        nodes[10].prev = nodes[9];

        nodes[8].child = nodes[11];
        nodes[11].next = nodes[12];
        nodes[12].prev = nodes[11];

        Node res = test.flatten(nodes[1]);
        test.printNode(res);
    }

    public void printNode (Node head) {
        Node p = head;
        while (p.next != null) {
            //System.out.print(p.val + "->");
            p = p.next;
        }
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.prev;
        }
    }


    public Node flatten(Node head) {
        Stack<Node> stack = new Stack();
        Node p = head;
        Node tail = p;
        while (p != null || !stack.empty()) {
            if (p == null) {
                p = stack.pop();
                tail.next = p;
                p.prev = tail;
            }
            if (p.child != null) {
                if (p.next != null) stack.add(p.next);
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
            }
            tail = p;
            p = p.next;
        }
        return head;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
