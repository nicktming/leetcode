package Solution_800_899;

import java.util.Arrays;

public class Solution_881 {

    public static void main(String[] args) {
        Solution_881 test = new Solution_881();
        int[] people = {3,5,3,4};
        int limit = 3;
        System.out.println(test.numRescueBoats(people, limit));
    }


    // first version
    // time: 27ms
    // beats: 94.22%
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int l = 0;
        int r = len - 1;
        int ans = 0;
        while (l < r) {
            if (people[l] + people[r] <= limit) {
                l ++;
            }
            r--;
            ans++;
        }
        return l == r ? ans + 1 : ans;
    }
}
