package Solution_900_999;

public class Solution_949 {
    int[] times = new int[4];
    int max = -1;
    String ans = "";
    public String largestTimeFromDigits(int[] A) {
        //Solution_949 test = new Solution_949();
        dfs(0, A);
        return ans;
    }

    public void dfs(int index, int[]A) {
        if (index == 4) {
            int hour = A[times[0]] * 10 + A[times[1]];
            int min  = A[times[2]] * 10 + A[times[3]];
            if (hour >= 0 && hour <= 23 && min >= 0 && min <= 59) {
                int mins = hour  * 60 + min;
                if (mins > max) {
                    max = mins;
                    ans = "" + A[times[0]] + A[times[1]] + ":" + A[times[2]] + A[times[3]];
                }
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            boolean flag = false;
            for (int j = 0; j < index; j++) {
                if (i == times[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                times[index] = i;
                dfs(index + 1, A);
            }
        }
    }
}
