package Solution_900_999;

public class Solution_900 {

    class RLEIterator {

        int[] A;
        int i = 0;
        int q = 0;

        public RLEIterator(int[] A) {
            this.A = A;
        }

        public int next(int n) {
            while (i < A.length) {
                if (q + n > A[i]) {
                    n -= A[i] - q;
                    q = 0;
                    i += 2;
                } else {
                    q += n;
                    return A[i + 1];
                }
            }
            return -1;
        }
    }

    /**
     *  version 2
     *  time : 66ms
     *  beats: 91.67%
     */

    /*
    class RLEIterator {

        long[][] presum;
        long current = 0;
        long sum = 0;
        int size = 0;
        int index = 0;
        public RLEIterator(int[] A) {
            presum = new long[A.length/2 + 1][2];
            for (int i = 0; i < A.length; i += 2) {
                if (A[i] == 0) continue;
                presum[size] = new long[2];
                presum[size][0] = (sum += A[i]);
                presum[size++][1] = A[i + 1];
            }
        }

        public int next(int n) {
            if ((current += n) > sum || index >= size) return -1;
            while (index < size) {
                if (presum[index][0] >= current) return (int)presum[index][1];
                index++;
            }
            return -1;
        }
    }
    */

    /**
     *  version1.
     *  time: 91ms
     *  beats: 46.55%

    class RLEIterator {

        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        long current = 0;
        long sum = 0;
        public RLEIterator(int[] A) {
            for (int i = 0; i < A.length; i += 2) {
                if (A[i] == 0) continue;
                treeMap.put(sum += A[i], A[i + 1]);
            }
        }

        public int next(int n) {
            if ((current += n) > sum) return -1;
            Map.Entry<Long, Integer> higher = treeMap.ceilingEntry(current);
            return higher == null ? -1 : higher.getValue();
        }
    }
     */

}

