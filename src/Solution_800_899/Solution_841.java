package Solution_800_899;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_841 {

    public static void main(String[] args) {
        Solution_841 test = new Solution_841();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(); l1.add(1); l1.add(3);
        List<Integer> l2 = new ArrayList<>(); l2.add(3); l2.add(0); l2.add(1);
        List<Integer> l3 = new ArrayList<>(); l3.add(2);
        List<Integer> l4 = new ArrayList<>();
        rooms.add(l1); rooms.add(l2); rooms.add(l3); rooms.add(l4);
        System.out.println(test.canVisitAllRooms(rooms));
    }

    //Set<Integer> set = new HashSet<Integer>();
    boolean[] visited;
    List<List<Integer>> rooms;
    int N;
    int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        this.N = rooms.size();
        visited = new boolean[N];
        dfs(0);
        return count == N;
    }

    public void dfs(int index) {
        if (visited[index]) return;
        visited[index] = true;
        ++count;
        //set.add(index);
        for (int next : rooms.get(index)) {
            dfs(next);
        }
    }
}
