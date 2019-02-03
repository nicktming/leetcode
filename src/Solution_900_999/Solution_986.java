package Solution_900_999;

import java.util.ArrayList;
import java.util.List;

public class Solution_986 {

    class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }

    public static void main(String[] args) {

    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i].start <= B[i].start) {
                if (A[i].end < B[i].start) {
                    i++;
                } else if (A[i].end <= B[i].end) {
                    ans.add(new Interval(B[i].start, A[i].end));
                    i++;
                } else {
                    ans.add(new Interval(B[i].start, B[i].end));
                    j++;
                }
            } else {
                if (B[i].end < A[i].start) {
                    j++;
                } else if (B[i].end <= A[i].end) {
                    ans.add(new Interval(A[i].start, B[i].end));
                    j++;
                } else {
                    ans.add(new Interval(A[i].start, A[i].end));
                    i++;
                }
            }
        }
        Interval[] res = new Interval[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            res[k] = ans.get(k);
        }
        return res;
    }
}
