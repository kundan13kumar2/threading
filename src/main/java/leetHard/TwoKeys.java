package leetHard;


public class TwoKeys {


    static int find(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) return 1;
        dp[1] = 1;
        if (n == 2) return 2;
        dp[2] = 2;
        if (n == 3) return 3;
        dp[3] = 3;
        if (n == 4) return 4;
        dp[4] = 4;
        if (n == 5) return 5;
        dp[5] = 5;

        for (int i = 6; i <= n; i++) {
            dp[i] = i;
            int j = i / 2;
            while (j >= 1) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i / j) - 1 + 1);
                }
                j--;
            }
        }
        return dp[n];
    }


    public static int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }

            dp[i] = Math.max(dp[i], dp[i - 1] + 1);
        }

        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(find(8));
    }
}
