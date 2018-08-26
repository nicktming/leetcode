package Solution_800_899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<String>();
        for (String word : words) {
            if (word.length() != pattern.length()) continue;
            Map<Character, Character> map = new HashMap<Character, Character>();
            boolean[] visited = new boolean[256];
            int i = 0;
            for (; i < word.length(); i++) {
                char w = pattern.charAt(i);
                char p = word.charAt(i);
                boolean exist = map.containsKey(w);
                if (exist && map.get(w) != p) break;
                if (!exist) {
                    if (visited[p - '0']) break;
                    map.put(w, p);
                    visited[p - '0'] = true;
                }
            }
            if (i == word.length()) ans.add(word);
        }
        return ans;
    }
}
