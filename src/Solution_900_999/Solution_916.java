package Solution_900_999;

import java.util.ArrayList;
import java.util.List;

public class Solution_916 {

    public static void main(String[] args) {
        Solution_916 test = new Solution_916();
        String[] A = {"amazon","apple","facebook","google","leetcode"};
        String[] B = {"lo", "eo"};
        for (String str : test.wordSubsets(A, B)) {
            System.out.println(str);
        }
    }

    /**
     *  time: 55ms
     *  beats: 100%
     */
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans = new ArrayList<>();
        int[] b_cnt = new int[26];
        for (String b : B) {
            int[] b_tmp = new int[26];
            for (char ch : b.toCharArray()) {
                b_tmp[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                b_cnt[i] = b_cnt[i] < b_tmp[i] ? b_tmp[i] : b_cnt[i];
            }
        }
        for (String a : A) {
            int[] a_tmp = new int[26];
            for (char ch : a.toCharArray()) {
                a_tmp[ch - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (a_tmp[i] < b_cnt[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(a);
        }
        return ans;
    }
}
