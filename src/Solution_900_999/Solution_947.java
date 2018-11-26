package Solution_900_999;

public class Solution_947 {
    public static void main(String[] args) {
        Solution_947 test = new Solution_947();
        //int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        //int[][] stones = {{0,0}, {0,2}, {1,1}, {2, 0}, {2, 2}};
        int[][] stones = {{5,9},{9,0},{0,0},{7,0},{4,3},{8,5},{5,8},{1,1},{0,6},{7,5},{1,6},{1,9},{9,4},{2,8},{1,3},{4,2},{2,5},{4,1},{0,2},{6,5}};
        System.out.println(test.removeStones(stones));
    }


    public int removeStones(int[][] stones) {
        int lenth = stones.length;
        UnionFind uf = new UnionFind(lenth);
        for (int i = 0; i < lenth; i++) {

        }
        return 0;
    }


    class UnionFind {
        int[] uf;
        public UnionFind(int lenth) {
            uf = new int[lenth];
            for (int i = 0; i < lenth; i++) {
                uf[i] = i;
            }
        }
        public int father(int k) {
            int fa = k;
            while (uf[fa] != fa) {
                fa = uf[fa];
            }
            while (uf[k] != fa) {
                k = uf[k];
                uf[k] = fa;
            }
            return fa;
        }
        public void union(int c1, int c2) {
            int fa1 = father(c1);
            int fa2 = father(c2);
            if (fa1 != fa2) {
                uf[fa1] = fa2;
            }
        }
    }
}
