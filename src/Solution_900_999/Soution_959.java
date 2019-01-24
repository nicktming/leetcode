package Solution_900_999;

public class Soution_959 {


    public static void main(String[] args) {

    }


    public int regionsBySlashes(String[] grid) {
        int ans = 0;
        int N = grid.length;
        UnionFind uf = new UnionFind(4 * N * N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int root = (i * N + j) * 4;
                char ch = grid[i].charAt(j);
                if (ch == '\\') {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                } else if (ch == '/') {
                    uf.union(root + 0, root + 3);
                    uf.union(root + 1, root + 2);
                } else {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                    uf.union(root + 0, root + 2);
                }

                if (j < N - 1) {
                    uf.union(root + 1, root + 7);
                }
                if (i < N - 1) {
                    uf.union(root + 2, root + 4 * N);
                }
            }
        }
        for (int i = 0; i < uf.parent.length; i++) {
            if (uf.parent[i] == i) ans++;
        }
        return ans;
    }


    class UnionFind {
        int[] parent;
        public UnionFind(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

}
