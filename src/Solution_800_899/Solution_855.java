package Solution_800_899;

import java.util.*;
import java.util.prefs.NodeChangeEvent;

public class Solution_855 {


    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        examRoom.printPQ();
        System.out.println(examRoom.seat());
        examRoom.printPQ();
        examRoom.leave(9);
        examRoom.printPQ();
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.printPQ();
        examRoom.leave(9);
        examRoom.printPQ();
        System.out.println(examRoom.seat());

    }

    static class ExamRoom {

        class Node {
            int left;
            int right;
            Node pre;
            Node next;
            public Node (int left, int right) {
                this.left = left;
                this.right = right;
            }
            public String toString() {
                return "[" + left + "," + right + "]";
            }
        }

        Node head;
        Node tail;
        int N;
        TreeSet<Node> pq;
        Map<Integer, Node> map;

        public ExamRoom(int N) {
            this.N = N;
            this.head = new Node(-1, -1);
            Node root = new Node(-1, N);
            head.next = root;
            root.pre = head;
            this.tail = root;
            this.pq = new TreeSet<Node>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    /*
                    int len_o2 = o2.right - o2.left - 1;
                    int len_o1 = o1.right - o1.left - 1;

                    len_o1 = len_o1 % 2 == 0 ? len_o1 / 2 : len_o1 / 2 + 1;
                    len_o2 = len_o2 % 2 == 0 ? len_o2 / 2 : len_o2 / 2 + 1;
                    */

                    int len_o1 = getLen(o1);
                    int len_o2 = getLen(o2);


                    if (len_o1 == len_o2) return o1.left - o2.left;
                    return len_o2 - len_o1;
                }

                public int getLen(Node o1) {
                    if (o1.left == -1 && o1.right == N) {
                        return N;
                    } else if (o1.left == -1 || o1.right == N) {
                        return o1.right - o1.left - 1;
                    } else {
                        int len_o1 = o1.right - o1.left - 1;
                        return len_o1 % 2 == 0 ? len_o1 / 2 : len_o1 / 2 + 1;
                    }
                }
            });
            this.pq.add(root);
            this.map = new HashMap<>();
        }

        public int seat() {
            Node cur = pq.pollFirst();
            int index = 0;
            if (cur.left == -1 && cur.right == this.N) {
            } else if (cur.left == -1) {
            } else if (cur.right == this.N) {
                index = this.N - 1;
            } else {
                index = cur.left + (cur.right - cur.left) / 2;
            }
            Node l = new Node(cur.left, index);
            Node r = new Node(index, cur.right);

            cur.pre.next = l;
            l.pre = cur.pre;
            l.next = r;
            r.pre = l;
            r.next = cur.next;
            if(cur.next != null) cur.next.pre = r;
            else this.tail = r;

            this.map.put(cur.left, l);
            this.map.put(index, r);

            this.pq.add(l);
            this.pq.add(r);

            return index;
        }

        public void leave(int p) {
            Node cur = this.map.get(p);
            Node pre = cur.pre;

            Node insert = new Node(pre.left, cur.right);
            pre.pre.next = insert;
            insert.pre = pre.pre;
            insert.next = cur.next;
            if (cur.next != null) cur.next.pre = insert;
            else this.tail = insert;

            this.map.remove(p);
            this.map.put(insert.left, insert);

            this.pq.remove(cur);
            this.pq.remove(pre);
            this.pq.add(insert);
        }

        public void printPQ() {
            System.out.println("=================");
            for (Node node : this.pq) {
                System.out.println(node);
            }
            System.out.println("=================");
        }
    }
}
