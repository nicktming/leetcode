package Solution_600_699;

public class Solution_622 {


    /**
     *  time: 64ms for 52 cases
     *  beats: 95.56%
     */
    class MyCircularQueue {

        int[] array;
        int front;
        int rear;
        int k;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            k++;
            this.array = new int[k];
            this.front = this.rear = 0;
            this.k = k;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) return false;
            this.rear = (this.rear + 1 + this.k) % this.k;
            this.array[this.rear] = value;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) return false;
            this.front = (this.front + 1 + this.k) % this.k;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return isEmpty() ? -1 : this.array[(this.front + 1 + this.k) % this.k];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return isEmpty() ? -1 : this.array[this.rear];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return this.front == this.rear;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return (this.rear + 1 + this.k) % this.k == this.front;
        }
    }
}
