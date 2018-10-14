package Solution_900_999;

public class Solution_922 {

    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        Solution_922 test = new Solution_922();
        for (int item : test.sortArrayByParityII(A)) {
            System.out.print(item);
        }
    }

    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        quickSort(A, 0, len - 1);
        int i = 1;
        int j = len - 2;
        while (i < j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i += 2;
            j -= 2;
        }
        return A;
    }

    public void quickSort(int[] A, int l, int r) {
        if (l > r) return;
        int val = A[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && A[j] % 2 == 1) j--;
            A[i] = A[j];
            while (i < j && A[i] % 2 == 0) i++;
            A[j] = A[i];
        }
        A[i] = val;
        quickSort(A, l, i - 1);
        quickSort(A, i + 1, r);
    }
}
