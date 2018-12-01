package Solution_600_699;

public class Solution_684 {

    public static void main(String[] args) {
        Solution_684 test = new Solution_684();
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] ans = test.findRedundantConnection(edges);
        System.out.println(ans[0] + "," + ans[1]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int[] edge: edges) {
            if (!uf.union(uf.father(edge[0]), uf.father(edge[1]))) {
                return edge;
            }
        }
        return null;
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
            this.fa[fa1] = fa2;
            return true;
        }
    }
}
