package leetHard;

public class ZeroOne {

    public int countZeroes(String str) {
        int counter = 0;
        for (char ch : str.toCharArray())
            if (ch == '0')
                counter++;
        return counter;
    }

    int max;

    public void recur(String[] arr, int size, int m, int n, int count) {


        if ((size < 0 || m < 0 || n < 0) || (m == 0 && n == 0)) {
            max = Math.max(max, count);
            return;
        }

        String str = arr[arr.length - 1 - size];
        int um = countZeroes(str);
        int un = str.length() - um;

        if (m - um >= 0 && n - un >= 0)
            recur(arr, size - 1, m - um, n - un, count + 1);
        recur(arr, size - 1, m, n, count);

    }

    public int countMaxMin(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < strs.length; i++) {
            int um = countZeroes(strs[i]);
            int un = strs[i].length() - um;
            for (int j = m; j >= um; j--) {
                for (int k = n; k >= un; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - um][k - un]);
                }
            }
        }

        return dp[m][n];

    }

    public static void main(String[] args) {
        ZeroOne zeroOne = new ZeroOne();
        String[] arr = {"10", "0001", "111001", "1", "0"};
        zeroOne.recur(arr, arr.length - 1, 5, 3, 0);
        System.out.println(zeroOne.max);
        System.out.println(zeroOne.countMaxMin(arr, 4, 3));
    }
}
