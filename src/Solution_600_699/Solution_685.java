package Solution_600_699;

import java.util.HashMap;
import java.util.Map;

public class Solution_685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        Map<Integer, Integer> parent = new HashMap<>();
        int[] res1 = null;
        int[] res2 = null;
        for (int[] edge : edges) {
            if (parent.containsKey(edge[1])) {
                res1 = new int[]{parent.get(edge[1]), edge[1]};
                res2 = new int[]{edge[0], edge[1]};
                edge[0] = edge[1] = -1;
            } else {
                parent.put(edge[1], edge[0]);
            }
        }

        for (int[] edge: edges) {
            if (edge[0] == -1 && edge[1] == -1) continue;
            if (!uf.union(uf.father(edge[0]), uf.father(edge[1]))) {
                return res1 == null ? edge : res1;
            }
        }
        return res2;
    }
    class UnionFind {
        int[] fa;
        public UnionFind(int lenth) {
            this.fa = new int[lenth];
            for (int i = 0; i < lenth; i++) {
                this.fa[i] = i;
            }
        }
        public int father(int current) {
            int father = current;
            while (father != fa[father]) {
                father = fa[father];
            }
            while (current != father) {
                current = fa[current];
                fa[current] = father;
            }
            return fa[current];
        }
        public boolean union(int fa1, int fa2) {
            if (fa1 == fa2) return false;
            this.fa[fa2] = fa1;
            return true;
        }
    }
}
