package leetHard;

public class PartitionArrayMaxSum {
    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int K = 3;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < K; i++) {
            max = Math.max(max, arr[i]);
            dp[i] = max * (i + 1);
        }

        for (int i = K; i < arr.length; i++) {
            int maxSubArray = arr[i];
            for (int j = 1; j <= K; j++) {
                maxSubArray = Math.max(maxSubArray, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], dp[i - j] + maxSubArray * j);
            }
        }
        System.out.println(dp[arr.length - 1]);
    }
}
