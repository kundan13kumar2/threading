package com.adobePrep;

public class Sort012 {
    public static int[] sort012(int[] arr) {
        int zero = 0;
        int two = arr.length - 1;
        while (arr[zero] == 0)
            zero++;
        while (arr[two] == 2)
            two--;
        int m = zero;
        while (m <= two) {
            switch (arr[m]) {
                case 0:
                    int temp = arr[zero];
                    arr[zero] = arr[m];
                    arr[m] = temp;
                    zero++;
                    m++;
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    int temp1 = arr[two];
                    arr[two] = arr[m];
                    arr[m] = temp1;
                    two--;
                    break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 2, 1, 0, 0, 2, 0, 1, 2};
        arr = sort012(arr);
        for (int k : arr)
            System.out.print(k + " ");
    }
}
