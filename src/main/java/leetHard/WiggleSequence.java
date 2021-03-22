package leetHard;

public class WiggleSequence {

    static int res = 0;
    static int n = 0;

    void recur(int[] arr, int t, int lastVal, int lastDiff, int l) {
        if (t == n) return;

        int currVal = arr[t];

        res = Math.max(res, l);

        if (t == 0) {
            recur(arr, t + 1, arr[t], arr[t], l + 1);
            recur(arr, t + 1, 0, 0, l);
        }

        int currDiff = currVal - lastVal;

        if (t > 1 && currDiff * lastDiff > 0) return;

        recur(arr, t + 1, arr[t], currDiff, l + 1);
        recur(arr, t + 1, lastVal, lastDiff, l);

    }

    boolean arraySortedOrNot(int arr[], int n) {
        if (n == 0 || n == 1)
            return true;
        for (int i = 1; i < n; i++)
            if (arr[i - 1] > arr[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {0,0};
        n = arr.length;


        WiggleSequence wiggleSequence = new WiggleSequence();
//        if (wiggleSequence.arraySortedOrNot(arr, n))
//            System.out.println(2);
        wiggleSequence.recur(arr, 0, 0, 0, 1);
        System.out.println(res);
    }
}
