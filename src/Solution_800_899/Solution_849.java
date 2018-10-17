package Solution_800_899;

public class Solution_849 {
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1 && pre == -1) {
                pre = i;
                ans = i;
            } else if (seats[i] == 1) {
                int tmp = (i - pre) / 2;
                ans = Math.max(tmp, ans);
                pre = i;
            } else if (i == seats.length - 1) {
                ans = Math.max(ans, seats.length - pre - 1);
            }
        }
        return ans;
    }
}
