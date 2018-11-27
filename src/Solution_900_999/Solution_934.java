package Solution_900_999;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution_934 {
    Queue<Integer> queue = new LinkedList<Integer>();
    Set<Integer> visited = new HashSet<Integer>();
    int[][] A;
    int row;
    int col;
    int ans;
    boolean flag = false;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestBridge(int[][] A) {
        this.A = A;
        this.row = A.length;
        this.col = A[0].length;
        int index = findOne();
        dfs(index/col, index%col);
        bfs();
        return ans;
    }

    public void bfs() {
        Queue<Integer> next = new LinkedList<>();
        while(!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int r = cur / col;
                int c = cur % col;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];
                    if (check(nr, nc) && !visited.contains(nr*col+nc)) {
                        if (A[nr][nc] == 1) return;
                        next.add(nr*col+nc);
                        visited.add(nr*col+nc);
                    }
                }
            }
            Queue<Integer> tmp = queue;
            queue = next;
            next = tmp;
            ans++;
        }
    }

    public int findOne() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) return i * col + j;
            }
        }
        return -1;
    }

    public void dfs(int r, int c) {
        if (!check(r, c)) return;
        queue.add(r*col+c);
        visited.add(r*col+c);
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (check(nr, nc) && A[nr][nc] == 1 && !visited.contains(nr*col+nc)) {
                dfs(nr, nc);
            }
        }
    }

    public boolean check(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }
}
