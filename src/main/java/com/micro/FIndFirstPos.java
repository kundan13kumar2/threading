package com.micro;

public class FIndFirstPos {

    int segregate(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        return j;
    }

    int find(int[] arr) {
        int shift = segregate(arr);
        int[] arr2 = new int[arr.length - shift];
        int j = 0;
        for (int i = shift; i < arr.length; i++) {
            arr2[j] = arr[i];
            j++;
        }
        for (int i = 0; i < j; i++) {
            int x = Math.abs(arr2[i]);
            if ((x - 1) < j && arr2[x - 1] > 0)
                arr2[x - 1] = -arr2[x - 1];
        }
        for (int i = 0; i < j; i++) {
            if (arr2[i] > 0)
                return i + 1;
        }
        return j + 1;
    }

    public static void main(String[] args) {
        FIndFirstPos fIndFirstPos = new FIndFirstPos();
        int arr[] = {1, 1, 0, -1, -2};
        System.out.println(fIndFirstPos.find(arr));
    }
}
