package Solution_900_999;

public class Solution_930 {

    public static void main(String[] args) {
        Solution_930 test = new Solution_930();
        int[] A = {0, 0, 0, 0, 0};
        int S = 0;
        // 1 1 2 2 3
        // 0 0 0 0 -> 0
        System.out.println(test.numSubarraysWithSum(A, S));
    }

    public int numSubarraysWithSum(int[] A, int S) {
        int ans = 0;
        int[] cnt = new int[30001];
        cnt[0] = 1;
        int presum = 0;
        for (int num : A) {
            presum += num;
            cnt[presum]++;
        }
        for (int i = S; i < 30001; i++) {
            if (cnt[i] == 0) break;
            int j = i - S;
            int tmp = cnt[i] * cnt[j];
            ans += i != j ? tmp : cnt[i] * (cnt[i] - 1)/2;
        }
        return ans;
    }
}
