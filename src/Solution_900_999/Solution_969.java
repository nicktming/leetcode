package Solution_900_999;

import java.util.ArrayList;
import java.util.List;

public class Solution_969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int index = getMax(A, A.length - i);
//            System.out.println("i:" + i + ", index:" + index);
            if (index == A.length - i - 1) continue;
            if(index > 0) {
                swap(A, 0, index);
                ans.add(index + 1);
            }
            if (A.length - i - 1 > 0){
                swap(A, 0, A.length - i - 1);
                ans.add(A.length - i);
            }
//            printA(A);
        }
        return ans;
    }

    public void printA(int[] A) {
        for (int t : A) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public void swap(int[]A, int l, int r) {
        if (l == r) return;
        int i = l;
        int j = r;
        while (i < j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
    }

    public int getMax(int[] A, int limit) {
        int max = -1;
        int index = 0;
        for (int i = 0; i < limit; i++) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        return index;
    }

}
