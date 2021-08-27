package leetHard;

public class TreeAncestor {
    int[] depth;
    int log = 0;
    int[][] dp;

    public TreeAncestor(int n, int[] parent) {

        while ((1 << log) <= n)
            log++;
        dp = new int[n][log];
        depth = new int[n];
        parent[0] = 0;
        for (int v = 0; v < n; v++) {
            dp[v][0] = parent[v];
           /* if (v != 0) {
                depth[v] = depth[parent[v]] + 1;
            }*/
            for (int j = 1; j < log; j++)
                dp[v][j] = dp[dp[v][j - 1]][j - 1];
        }
    }

    public int getKthAncestor(int node, int k) {
        if (log < k) return -1;
        for (int i = log - 1; i >= 0; i--) {
            if (k >= (1 << i)) {
                node = dp[node][i];
                k -= (1 << i);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        //int[] par = {-1, 0, 0, 1, 1, 2, 2};
        int[] par = {-1, 2, 3, 0};
        int n = 4;
        TreeAncestor tr = new TreeAncestor(n, par);
        int p = tr.getKthAncestor(2, 2);
        System.out.println("sdf" + p);
    }
}
