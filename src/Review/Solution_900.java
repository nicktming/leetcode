package Review;

public class Solution_900 {

    public static void main(String[] args) {
        int[] A = {3, 8, 0, 9, 2, 5};
        RLEIterator rlet = new RLEIterator(A);
        System.out.println(rlet.next(2));
        System.out.println(rlet.next(1));
        System.out.println(rlet.next(1));
        System.out.println(rlet.next(2));
    }

    static class RLEIterator {

        int[] A;
        int index;
        int current;

        public RLEIterator(int[] A) {
            this.A = A;
        }

        public int next(int n) {
            while (index < A.length) {
                if (current + n <= A[index]) {
                    current += n;
                    return A[index + 1];
                } else {
                    n = n + current - A[index];
                    current = 0;
                    index += 2;
                }
            }
            return -1;
        }
    }
}
