import java.util.Arrays;

public class RemoveDup {

    public static void main(String[] args) {

        int[] A = new int[]{1, 3, 7};
        int[] B = new int[]{2, 6, 8};
        int C = 1;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            if (i + C < A.length && A[i + C] < B[i]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);


        int start = 0;
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 5, 6, 6};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i < n - 2 && arr[i + 1] == arr[i] && arr[i + 2] == arr[i])
                continue;
            else {
                arr[start] = arr[i];
                start++;
            }
        }
        for (int i = 0; i < start; i++)
            System.out.println(arr[i]);

        char[] chars = {'g', 'e', 'e', 'k', 's'};
        start = 0;
        n = chars.length;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && chars[i + 1] == chars[i])
                continue;
            else {
                chars[start] = chars[i];
                start++;
            }
        }
        for (int i = 0; i < start; i++)
            System.out.println(chars[i]);
    }
}
