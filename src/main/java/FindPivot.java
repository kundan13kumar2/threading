public class FindPivot {
    public static int findPivotIndex(int[] arr) {

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid <= arr.length && arr[mid] > arr[mid + 1])
                return mid + 1;
            else if (arr[l] <= arr[mid])
                l = mid + 1;
            else r = mid - 1;
        }
        return 0;
    }

    public static int findElement(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid <= arr.length && arr[mid] == k)
                return mid;
            else if (arr[l] <= arr[mid]) {
                if (k >= arr[l] && k <= arr[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (arr[mid] <= k && arr[r] >= k)
                    l = mid + 1;
                else r = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9, 1, 2};
        System.out.println(findElement(arr, 8));
        System.out.println(findElement(arr, 8));

    }
}
