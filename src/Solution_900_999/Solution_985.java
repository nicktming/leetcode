package Solution_900_999;

public class Solution_985 {


    public static void main(String[] args) {
        Solution_985 test = new Solution_985();
        int[] A = {5, 5, 4};
        int[][] queries = {{0,1},{1,0},{4,1}};
        int[] ans = test.sumEvenAfterQueries(A, queries);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int lenth = queries.length;
        int[] ans = new int[lenth];
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) total += A[i];
        }
        ans[0] = total;
        for (int i = 0; i < lenth; i++) {
            int before = A[queries[i][1]];
            int after = A[queries[i][1]] + queries[i][0];
            if (before % 2 == 0 && after % 2 == 0) {
                ans[i] = total += queries[i][0];
            } else if (before % 2 != 0 && after % 2 == 0) {
                ans[i] = total += after;
            } else if (before % 2 == 0 && after % 2 != 0) {
                ans[i] = total -= before;
            } else {
                ans[i] = total;
            }
            A[queries[i][1]] = after;
            printA(A);
        }
        return ans;
    }

    public void printA(int[] nums) {
        System.out.println("------------------");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("\n------------------");
    }
}
