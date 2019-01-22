package Solution_900_999;

public class Solution_961 {


    public static void main(String[] args) {
        Solution_961 test = new Solution_961();
        int[] A = {5,1,5,2,5,3,5,4};
        System.out.println(test.repeatedNTimes(A));
    }

    public int repeatedNTimes(int[] A) {
        int[] hash = new int[10000];
        for (int a : A) {
            hash[a] += 1;
            if (hash[a] == A.length/2) return a;
        }
        return -1;
    }
}
