package leetHard;

public class PartitionArr {

    public boolean recur(int sum, int i, int[] arr) {
        if (sum == 0) return true;
        if (i == 0) return false;

        if (arr[i] > sum) return recur(sum, i - 1, arr);

        return recur(sum, i - 1, arr) || recur(sum - arr[i], i - 1, arr);

    }

    public boolean dpSolution(int sum, int n, int[] arr) {
        boolean[][] dp = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= n; i++)
            dp[0][i] = true;
        for (int i = 1; i <= sum; i++)
            dp[i][0] = false;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= arr[j - 1]) {
                    //         Not Taking   || Taking
                    dp[i][j] = dp[i][j - 1] || dp[i - arr[j - 1]][j - 1];
                }
            }
        }

        return dp[sum][n];
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 2, 2, 1};
        int n = arr.length;
        int sum = 0;
        for (int k : arr)
            sum += k;
        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }
        PartitionArr partitionArr = new PartitionArr();
        System.out.println(partitionArr.dpSolution(sum / 2, n - 1, arr));
    }
}
