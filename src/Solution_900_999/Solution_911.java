package Solution_900_999;

public class Solution_911 {

    public static void main(String[] args) {
        int[] persons = {0, 0, 0, 1, 1};
        int[] times = {9, 79, 86, 99, 100};
        TopVotedCandidate tv = new TopVotedCandidate(persons, times);
        int[] test = {3, 12, 25, 15, 24, 8};
/*
        for (int t : test) {
            System.out.println(tv.q(t));
        }
*/

    }

    static class TopVotedCandidate {

        int[] votes = new int[5001];
        int[] candidate;
        int[] times;
        int len;

        public TopVotedCandidate(int[] persons, int[] times) {
            int len = persons.length;
            candidate = new int[len];
            candidate[0] = persons[0];
            votes[persons[0]]++;
            for (int i = 1; i < len; i++) {
                int best = candidate[i - 1];
                candidate[i] = candidate[i - 1];
                if (++votes[persons[i]] >= votes[best]) {
                    candidate[i] = persons[i];
                }
            }
            this.len = times.length;
            this.times = times;

            for (int c : candidate) {
                System.out.print(c + ", ");
            }
        }

        public int q(int t) {
            int index = getMaxIndex(0, len - 1, t);
            return candidate[index - 1];
        }

        public int getMaxIndex(int start, int end, int t) {
            if (t >= times[end])    return end + 1;
            if (t < times[start])   return start;
            int i = start;
            int j = end;
            while (i + 1 < j) {
                int mid = i + (j - i) / 2;
                if (times[mid] <= t) {
                    i = mid;
                } else {
                    j = mid;
                }
            }
            return times[i] > t ? i : j;
        }
    }

}
