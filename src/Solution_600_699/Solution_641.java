package Solution_600_699;

public class Solution_641 {


    public static void main(String[] args) {
        MyCircularDeque mc = new MyCircularDeque(5);
        System.out.println(mc.insertFront(7));
        System.out.println(mc.insertLast(0));
        System.out.println(mc.getFront());
        System.out.println("front:" + mc.front + ", rear:" + mc.rear);
        //System.out.println(mc.insertFront(3));
        //System.out.println(mc.insertFront(4));
        //System.out.println(mc.getRear());
    }

    static class MyCircularDeque {

        int[] array;
        int front;
        int rear;
        int k;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            k++;
            this.array = new int[k];
            this.front = this.rear = 0;
            this.k = k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) return false;
            this.array[this.front] = value;
            this.front = (this.front - 1 + this.k) % this.k;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) return false;
            this.rear = (this.rear + 1 + this.k) % this.k;
            this.array[this.rear] = value;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) return false;
            this.front = (this.front + 1 + this.k) % this.k;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) return false;
            this.rear = (this.rear - 1 + this.k) % this.k;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return isEmpty() ? -1 : this.array[(this.front + 1 + this.k)%this.k];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return isEmpty() ? -1 : this.array[this.rear];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return this.front == this.rear;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (this.rear + 1 + this.k) % this.k == this.front;
        }
    }

    /**
     *  version : 1
     *  time: 79ms for 51 cases
     *  beats: 44.15%

    class MyCircularDeque {

        class Node {
            int value;
            Node next;
            Node pre;
            public Node(int value) {this.value = value;}
        }

        Node head;
        Node rear;
        int size;
        int k;


        public MyCircularDeque(int k) {
            this.head = new Node(-1);
            this.rear = head;
            this.size = 0;
            this.k = k;
        }


        public boolean insertFront(int value) {
            if (isFull()) return false;
            Node insert = new Node(value);
            insert.next = head.next;
            head.next = insert;
            insert.pre = head;
            if (insert.next == null) rear = insert;
            else insert.next.pre = insert;
            this.size++;
            return true;
        }


        public boolean insertLast(int value) {
            if (isFull()) return false;
            Node insert = new Node(value);
            rear.next = insert;
            insert.pre = rear;
            rear = insert;
            this.size++;
            return true;
        }


        public boolean deleteFront() {
            if (isEmpty()) return false;
            Node front = head.next;
            head.next = front.next;
            if (front == rear) rear = head;
            else front.next.pre = head;
            this.size--;
            return true;
        }


        public boolean deleteLast() {
            if (isEmpty()) return false;
            Node pre = rear.pre;
            pre.next = null;
            if (pre == head) rear = head;
            else rear = pre;
            this.size--;
            return true;
        }


        public int getFront() {
            return isEmpty() ? -1 : head.next.value;
        }


        public int getRear() {
            return isEmpty() ? -1 : rear.value;
        }


        public boolean isEmpty() {
            return this.size == 0 && this.head == this.rear;
        }


        public boolean isFull() {
            return this.size >= k;
        }
    }
    */
}
